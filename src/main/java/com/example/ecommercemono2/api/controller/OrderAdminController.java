package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.order.GetAllOrderResponse;
import com.example.ecommercemono2.business.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/order")
@AllArgsConstructor
public class OrderAdminController {
    private final OrderService service;
    @GetMapping
    public List<GetAllOrderResponse> getAll(){
        return service.getAll();
    }
}
