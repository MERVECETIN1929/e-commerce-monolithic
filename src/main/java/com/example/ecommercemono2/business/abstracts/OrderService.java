package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.order.CreateOrderRequest;

import java.util.UUID;

public interface OrderService {
    void add(CreateOrderRequest request);
    void cancel(UUID userId,UUID orderId);

}
