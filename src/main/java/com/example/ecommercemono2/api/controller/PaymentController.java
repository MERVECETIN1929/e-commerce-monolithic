package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.PaymentService;

import com.example.ecommercemono2.business.dto.request.payment.CreatePaymentRequest;
import com.example.ecommercemono2.business.dto.request.payment.UpdatePaymentRequest;
import com.example.ecommercemono2.business.dto.response.payment.CreatePaymentResponse;
import com.example.ecommercemono2.business.dto.response.payment.GetAllPaymentsResponse;
import com.example.ecommercemono2.business.dto.response.payment.GetPaymentResponse;
import com.example.ecommercemono2.business.dto.response.payment.UpdatePaymentResponse;
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
    public CreatePaymentResponse add(@RequestBody CreatePaymentRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable UUID id, @RequestBody UpdatePaymentRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetPaymentResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllPaymentsResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
