package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.response.orderDetails.GetAllOrderDetailsResponse;
import com.example.ecommercemono2.entities.Order;
import com.example.ecommercemono2.entities.OrderDetails;

import java.util.List;
import java.util.UUID;

public interface OrderDetailsService {
    void addOrderDetailsByCartId(UUID cartId, Order order);
    List<GetAllOrderDetailsResponse> getAllOrderDetailsByOrderId(UUID orderId);

}
