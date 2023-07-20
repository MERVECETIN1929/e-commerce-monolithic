package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.OrderDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/order-detail")
@RestController
@AllArgsConstructor
public class OrderDetailsController {
    private final OrderDetailsService service;

}
