package com.example.ecommercemono2.business.abstracts;


import com.example.ecommercemono2.business.dto.request.cart.CreateCartRequest;
import com.example.ecommercemono2.business.dto.request.cart.UpdateCartRequest;
import com.example.ecommercemono2.business.dto.response.cart.CreateCartResponse;
import com.example.ecommercemono2.business.dto.response.cart.GetAllCartsResponse;
import com.example.ecommercemono2.business.dto.response.cart.GetCartResponse;
import com.example.ecommercemono2.business.dto.response.cart.UpdateCartResponse;
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
