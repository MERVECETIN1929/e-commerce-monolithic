package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.brand.BrandService;
import com.example.ecommercemono2.business.brand.GetAllBrandsResponse;
import com.example.ecommercemono2.business.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/brand")
@AllArgsConstructor
public class BrandController {
    // todo add http status code
    private final BrandService service;



    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return service.getAll();
    }


}
