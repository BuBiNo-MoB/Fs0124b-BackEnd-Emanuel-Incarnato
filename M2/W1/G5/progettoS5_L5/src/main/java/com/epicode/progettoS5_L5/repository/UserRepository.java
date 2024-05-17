package com.epicode.progettoS5_L5.repository;

import com.epicode.progettoS5_L5.data.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
