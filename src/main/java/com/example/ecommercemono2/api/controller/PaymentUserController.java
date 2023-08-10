package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.paymet.PaymentService;
import com.example.ecommercemono2.business.paymet.UpdatePaymentRequest;
import com.example.ecommercemono2.business.paymet.UpdatePaymentResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/user/payment")
@AllArgsConstructor
public class PaymentUserController {
    private final PaymentService service;
    @PutMapping("/{id}")
    public UpdatePaymentResponse update(@PathVariable UUID id, @Valid @RequestBody UpdatePaymentRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
