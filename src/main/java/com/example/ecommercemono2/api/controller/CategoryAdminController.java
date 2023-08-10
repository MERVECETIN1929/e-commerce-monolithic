package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.category.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/admin/category")
public class CategoryAdminController {
    private final CategoryService service;
    @PostMapping
    public CreateCategoryResponse add(@Valid @RequestBody CreateCategoryRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable UUID id, @Valid  @RequestBody UpdateCategoryRequest request) {
        return service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
