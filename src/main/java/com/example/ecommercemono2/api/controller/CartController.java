package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.cart.CartService;
import com.example.ecommercemono2.business.cart.CreateCartRequest;
import com.example.ecommercemono2.business.cart.CreateCartResponse;
import com.example.ecommercemono2.business.cart.GetCartResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {
    // todo add http status code
    private final CartService service;

    @PostMapping
    public CreateCartResponse add(@Valid @RequestBody CreateCartRequest request) {
        return service.add(request);
    }
    @GetMapping("/{id}")
    @PostAuthorize("returnObject.userId==authentication.principal.id")
    public GetCartResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }




}
