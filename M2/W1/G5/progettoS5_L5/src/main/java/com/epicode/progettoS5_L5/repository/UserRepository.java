package com.epicode.progettoS5_L5.repository;

import com.epicode.progettoS5_L5.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(long id);
}
