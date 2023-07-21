package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.order.CreateOrderRequest;
import com.example.ecommercemono2.business.dto.response.order.GetAllOrderResponse;
import com.example.ecommercemono2.business.dto.response.order.GetOrderResponse;
import com.example.ecommercemono2.common.dto.PaymentRequest;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    void add(CreateOrderRequest request);
    void cancel(UUID userId, UUID orderId, PaymentRequest request);
    List<GetAllOrderResponse> getAll();
    List<GetAllOrderResponse> getAll(UUID userId);
    GetOrderResponse getById(UUID id);

}
