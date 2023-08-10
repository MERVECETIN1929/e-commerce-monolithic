package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.product.GetAllProductsResponse;
import com.example.ecommercemono2.business.product.GetProductResponse;
import com.example.ecommercemono2.business.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service;
    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllProductsResponse> getAll() {
        return service.getAll();
    }


}
