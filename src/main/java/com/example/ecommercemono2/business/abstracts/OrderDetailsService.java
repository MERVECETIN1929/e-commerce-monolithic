package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.entities.Order;

import java.util.UUID;

public interface OrderDetailsService {
    void addOrderDetailsByCartId(UUID cartId, Order order);
}
