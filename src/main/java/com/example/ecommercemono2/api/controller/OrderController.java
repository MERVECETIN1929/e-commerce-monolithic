package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.OrderService;
import com.example.ecommercemono2.business.dto.request.order.CreateOrderRequest;
import com.example.ecommercemono2.business.dto.response.order.GetAllOrderResponse;
import com.example.ecommercemono2.common.dto.PaymentRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {
    private final OrderService service;
    //todo order address alma yöntemi hakkında biraz daha düşün
    @PostMapping
    public void add(@RequestBody CreateOrderRequest request){
        service.add(request);
    }
    @GetMapping
    public List<GetAllOrderResponse> getAll(){
        return service.getAll();
    }
    @GetMapping("/{userId}")
    public List<GetAllOrderResponse> getAll(@PathVariable UUID userId){
        return service.getAll(userId);
    }
    @DeleteMapping("/{userId}/{orderId}")
    public void cancel(@PathVariable UUID userId, @PathVariable UUID orderId, @RequestBody PaymentRequest request){
        service.cancel(userId, orderId, request);
    }
}
