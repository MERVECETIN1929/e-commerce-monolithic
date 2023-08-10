package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.paymet.PaymentService;

import com.example.ecommercemono2.business.paymet.CreatePaymentRequest;
import com.example.ecommercemono2.business.paymet.UpdatePaymentRequest;
import com.example.ecommercemono2.business.paymet.CreatePaymentResponse;
import com.example.ecommercemono2.business.paymet.GetAllPaymentsResponse;
import com.example.ecommercemono2.business.paymet.GetPaymentResponse;
import com.example.ecommercemono2.business.paymet.UpdatePaymentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService service;
    @PostMapping
    public CreatePaymentResponse add(@Valid @RequestBody CreatePaymentRequest request) {
        return service.add(request);
    }



    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

}
