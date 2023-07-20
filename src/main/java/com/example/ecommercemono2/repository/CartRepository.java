package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {
    boolean existsCartById(UUID cartId);
    Cart findByUserId(UUID userId);
    @Query("select sum(ct.totalPrice) from Cart c inner join CartItem ct on ct.cart.id=c.id where ct.cart.id=:cartId")
    Optional<Double> calculateTotalPrice(@Param("cartId") UUID cartId);
}
