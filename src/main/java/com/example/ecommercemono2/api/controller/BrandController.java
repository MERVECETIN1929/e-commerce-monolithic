package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.BrandService;
import com.example.ecommercemono2.business.dto.request.brand.CreateBrandRequest;
import com.example.ecommercemono2.business.dto.request.brand.UpdateBrandRequest;
import com.example.ecommercemono2.business.dto.response.brand.CreateBrandResponse;
import com.example.ecommercemono2.business.dto.response.brand.GetAllBrandsResponse;
import com.example.ecommercemono2.business.dto.response.brand.GetBrandResponse;
import com.example.ecommercemono2.business.dto.response.brand.UpdateBrandResponse;
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

    @PostMapping
    public CreateBrandResponse add(@RequestBody CreateBrandRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponse update(@PathVariable UUID id, @RequestBody UpdateBrandRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetBrandResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllBrandsResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
