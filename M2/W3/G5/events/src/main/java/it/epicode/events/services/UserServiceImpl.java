package it.epicode.events.services;

import it.epicode.events.Mapper;
import it.epicode.events.dto.LoginResponseDto;
import it.epicode.events.dto.RegisterUserDto;
import it.epicode.events.dto.RegisteredUserDto;
import it.epicode.events.entities.RoleEntity;
import it.epicode.events.entities.UserEntity;
import it.epicode.events.repositories.RoleRepository;
import it.epicode.events.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    Mapper<RegisterUserDto, UserEntity> mapEntity;
    @Autowired
    Mapper<UserEntity, RegisteredUserDto> mapRegisteredUser;
    @Autowired
    Mapper<UserEntity, LoginResponseDto> mapLogin;

    @Override
    public List<UserEntity> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUser(Long id) {
        try {
            return userRepository.findById(id);
        }catch (Exception ex){
            log.error(String.format("utente con id = non trovato",id),ex);
            return Optional.empty();
        }
    }

    @Override
    public UserEntity save(UserEntity user) {
        try {
            return userRepository.save(user);
        }catch (Exception ex){
            log.error(String.format("salvataggio non riuscito di",user),ex);
            return null;
        }
    }

    @Override
    public Optional<UserEntity> update(Long userId, User user) {
        try{
            var ute = userRepository.findById(userId).orElseThrow();
            ute.builder()
                    .withUsername(ute.getUsername())
                    .withEmail(ute.getEmail())
                    .withPassword(ute.getPassword())
                    .build();
            return Optional.of(userRepository.save(ute));
        }
        catch (NoSuchElementException ex){
            log.error(String.format("utente con id = %s non trovato", userId), ex);
        }
        return Optional.empty();
    }

    @Override
    public Optional<UserEntity> delete(Long userId) {
        try{
            var ute = userRepository.findById(userId).orElseThrow();
            userRepository.delete(ute);
            return Optional.of(ute);
        }catch (NoSuchElementException ex){
            log.error(String.format("utente non trovato con id = %s",userId),ex);
            throw new RuntimeException("non trovo l'utente...");
        }catch (Exception ex){
            log.error(String.format("errore eliminazione utente con id = %s",userId),ex);
            throw new RuntimeException();
        }
    }

    @Override
    public RegisteredUserDto register(RegisterUserDto user) {
        try {
            var u = mapEntity.map(user);
            var p = encoder.encode(user.getPassword());
            log.info("Password encrypted: {}", p);
            u.setPassword(p);
            if (user.getRoles() != null)
                Stream.of(user.getRoles().split(",")).forEach(r -> u.getRoles().add(roleRepository.findOneByName(r) //
                        .orElse(roleRepository.save(RoleEntity.builder().withName(r).build()))));
            return mapRegisteredUser.map(userRepository.save(u));
        } catch (Exception e) {
            log.error(String.format("Exception saving user %s", user), e);
            throw new PersistEntityException(user);
        }
    }

    @Override
    public Optional<LoginResponseDto> login(String username, String password) {
        try {
            var a = auth.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            a.getAuthorities();
            SecurityContextHolder.getContext().setAuthentication(a);

            var dto = mapLogin.map(userRepository.findOneByUsername(username).orElseThrow());
            dto.setToken(jwt.generateToken(a));
            return Optional.of(dto);
        } catch (NoSuchElementException e) {
            log.error("User not found", e);
            throw new InvalidLoginException(username, password);
        } catch (AuthenticationException e) {
            log.error("Authentication failed", e);
            throw new InvalidLoginException(username, password);
        }
    }

    @Override
    public Optional<RegisteredUserDto> get(long id) {
        try {
            return Optional.of(mapRegisteredUser.map(userRepository.findById(id).orElseThrow()));
        } catch (Exception e) {
            log.error(String.format("User not found for id %s", id), e);
            return Optional.empty();
        }
    }
}
