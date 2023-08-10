package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.cart.CartService;
import com.example.ecommercemono2.business.cart.UpdateCartRequest;
import com.example.ecommercemono2.business.cart.GetAllCartsResponse;
import com.example.ecommercemono2.business.cart.UpdateCartResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/cart")
public class CartAdminController {
    private final CartService cartService;
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        cartService.delete(id);
    }
    @PutMapping("/{id}")
    public UpdateCartResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateCartRequest request) {
        return cartService.update(id, request);
    }
    @GetMapping
    public List<GetAllCartsResponse> getAll() {
        return cartService.getAll();
    }
}
