package it.epicode.events.services;

import it.epicode.events.entities.UserEntity;
import it.epicode.events.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


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
    public Optional<UserEntity> update(Long userId, UserEntity user) {
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
}
