package com.example.ecommercemono2.business.cart;


import com.example.ecommercemono2.entities.Cart;

import java.util.List;
import java.util.UUID;

public interface CartService {
    CreateCartResponse add(CreateCartRequest request);

    UpdateCartResponse update(UUID cartId, UpdateCartRequest request);

    GetCartResponse getById(UUID cartId);

    List<GetAllCartsResponse> getAll();

    void delete(UUID cartId);

    void addPriceTotalPrice(double addPrice, UUID cartId);

    void minusPriceTotalPrice(double minusPrice, UUID cartId);

    double changeTotalPrice(UUID id);
    Cart getCartByUserId(UUID userId);
    void clearCart(UUID cartId);
}
