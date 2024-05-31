package it.epicode.events.services;

import it.epicode.events.dto.LoginResponseDto;
import it.epicode.events.dto.RegisterUserDto;
import it.epicode.events.dto.RegisteredUserDto;
import it.epicode.events.entities.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> getUser();

    Optional<UserEntity> getUser(Long id);

    UserEntity save(UserEntity user);

    Optional<UserEntity> update(Long userId, User user);

    Optional<UserEntity> delete(Long userId);

    RegisteredUserDto register(RegisterUserDto user);

    Optional<LoginResponseDto> login(String username, String password);

    Optional<RegisteredUserDto> get(long id);
}
