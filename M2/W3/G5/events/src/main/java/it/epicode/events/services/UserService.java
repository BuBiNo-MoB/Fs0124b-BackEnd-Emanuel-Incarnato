package it.epicode.events.services;

import it.epicode.events.entities.UserEntity;
import org.apache.catalina.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserEntity> getUser();

    Optional<UserEntity> getUser(Long id);

    UserEntity save(UserEntity user);

    Optional<UserEntity> update(Long userId, UserEntity utente);

    Optional<UserEntity> delete(Long userId);
}
