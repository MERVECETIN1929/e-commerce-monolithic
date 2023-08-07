package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.OrderService;
import com.example.ecommercemono2.business.dto.request.order.CreateOrderRequest;
import com.example.ecommercemono2.business.dto.response.order.GetAllOrderResponse;
import com.example.ecommercemono2.common.dto.PaymentRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("#request.userId.equals(authentication.principal.id)")
    public void add(@Valid @RequestBody CreateOrderRequest request){
        service.addRequest(request);
    }

    @GetMapping
    public List<GetAllOrderResponse> getAll(){
        return service.getAll();
    }

    @GetMapping("/{userId}")
    @PreAuthorize("#userId.equals(authentication.principal.id)")
    public List<GetAllOrderResponse> getAll(@PathVariable UUID userId){
        return service.getAll(userId);
    }

    @DeleteMapping("/{userId}/{orderId}")
    @PreAuthorize("#userId.equals(authentication.principal.id)")
    public void cancel(@PathVariable UUID userId, @PathVariable UUID orderId,@Valid  @RequestBody PaymentRequest request){
        service.cancel(userId, orderId, request);
    }
}
