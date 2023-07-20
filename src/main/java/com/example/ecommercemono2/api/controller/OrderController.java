package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.OrderService;
import com.example.ecommercemono2.business.dto.request.order.CreateOrderRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
