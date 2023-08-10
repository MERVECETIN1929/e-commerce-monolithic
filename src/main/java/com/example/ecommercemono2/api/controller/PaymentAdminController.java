package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.paymet.GetAllPaymentsResponse;
import com.example.ecommercemono2.business.paymet.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/payment")
@AllArgsConstructor
public class PaymentAdminController {
    private final PaymentService service;
    @GetMapping
    public List<GetAllPaymentsResponse> getAll() {
        return service.getAll();
    }
}
