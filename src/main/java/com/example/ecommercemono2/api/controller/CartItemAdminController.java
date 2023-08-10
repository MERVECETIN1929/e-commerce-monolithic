package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.cartItem.CartItemService;
import com.example.ecommercemono2.business.cartItem.GetAllCartItemsResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/cartItem")
public class CartItemAdminController {
    private final CartItemService service;
    @GetMapping
    public List<GetAllCartItemsResponse> getAll() {
        return service.getAll();
    }
}
