package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    boolean existsCartById(UUID cartId);
}
