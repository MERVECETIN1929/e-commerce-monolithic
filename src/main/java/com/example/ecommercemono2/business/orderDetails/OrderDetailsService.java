package com.example.ecommercemono2.business.orderDetails;

import com.example.ecommercemono2.entities.Order;

import java.util.List;
import java.util.UUID;

public interface OrderDetailsService {
    void addOrderDetailsByCartId(UUID cartId, Order order);
    List<GetAllOrderDetailsResponse> getAllOrderDetailsByOrderId(UUID orderId);

}
