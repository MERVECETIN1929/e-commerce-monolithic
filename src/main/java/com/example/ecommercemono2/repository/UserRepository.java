package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsUserById(UUID id);

    boolean existsUserByEmail(String mail);

    Optional<User> findUserByEmail(String  email);
}
