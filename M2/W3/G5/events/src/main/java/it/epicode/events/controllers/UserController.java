package it.epicode.events.controllers;

import it.epicode.events.entities.UserEntity;
import it.epicode.events.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUser(){
        List<UserEntity> user = userService.getUser();
        return  ResponseEntity.ok(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userService.getUser(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable Long id, @RequestBody User user) {
        Optional<UserEntity> updatedUte = userService.update(id, user);
        return updatedUte.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        Optional<UserEntity> deletedUte= userService.delete(id);
        if (deletedUte.isPresent()) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
