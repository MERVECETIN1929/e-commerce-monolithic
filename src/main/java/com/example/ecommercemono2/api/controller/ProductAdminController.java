package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.product.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/product")
public class ProductAdminController {
    private final ProductService service;
    @PostMapping
    public CreateProductResponse add(@Valid @RequestBody CreateProductRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable UUID id, @Valid  @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PutMapping("/change-product-unit-price/{id}")
    public void changeProductUnitPrice(@PathVariable UUID id,@Valid  @RequestBody ChangeProductUnitPrice changeProductUnitPrice) {
        service.changeProductUnitPrice(id, changeProductUnitPrice);
    }
}
