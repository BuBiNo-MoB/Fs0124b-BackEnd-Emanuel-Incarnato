package it.epicode.events.repositories;

import it.epicode.events.entities.Event;
import it.epicode.events.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
