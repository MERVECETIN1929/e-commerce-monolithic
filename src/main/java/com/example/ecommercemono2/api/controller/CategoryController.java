package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.CategoryService;
import com.example.ecommercemono2.business.dto.request.category.CreateCategoryRequest;
import com.example.ecommercemono2.business.dto.request.category.UpdateCategoryRequest;
import com.example.ecommercemono2.business.dto.response.category.CreateCategoryResponse;
import com.example.ecommercemono2.business.dto.response.category.GetAllCategoriesResponse;
import com.example.ecommercemono2.business.dto.response.category.GetCategoryResponse;
import com.example.ecommercemono2.business.dto.response.category.UpdateCategoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService service;
    @PostMapping
    public CreateCategoryResponse add(@RequestBody CreateCategoryRequest request){
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable UUID id,@RequestBody UpdateCategoryRequest request){
        return service.update(id,request);
    }
    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @GetMapping
    public List<GetAllCategoriesResponse> getAll(){
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
