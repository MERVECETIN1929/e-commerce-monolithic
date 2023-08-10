package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.brand.BrandService;
import com.example.ecommercemono2.business.brand.CreateBrandRequest;
import com.example.ecommercemono2.business.brand.UpdateBrandRequest;
import com.example.ecommercemono2.business.brand.CreateBrandResponse;
import com.example.ecommercemono2.business.brand.UpdateBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/brand")
@AllArgsConstructor
public class BrandAdminController {
    private final BrandService brandService;
    @PostMapping
    public CreateBrandResponse add(@Valid @RequestBody CreateBrandRequest request) {
        return brandService.add(request);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse update(@PathVariable UUID id, @Valid  @RequestBody UpdateBrandRequest request) {
        return brandService.update(id, request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        brandService.delete(id);
    }
}
