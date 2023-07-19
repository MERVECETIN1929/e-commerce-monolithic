package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartItemRepository extends JpaRepository<CartItem, UUID> {
    boolean existsCartItemById(UUID cartItemId);

    boolean existsCartItemByCartIdAndProductId(UUID cartId, UUID productId);

    CartItem findCartItemByCartIdAndProductId(UUID cartId, UUID productId);
}
