package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.category.CategoryService;
import com.example.ecommercemono2.business.category.CreateCategoryRequest;
import com.example.ecommercemono2.business.category.UpdateCategoryRequest;
import com.example.ecommercemono2.business.category.CreateCategoryResponse;
import com.example.ecommercemono2.business.category.GetAllCategoriesResponse;
import com.example.ecommercemono2.business.category.GetCategoryResponse;
import com.example.ecommercemono2.business.category.UpdateCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService service;



    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return service.getAll();
    }


}
