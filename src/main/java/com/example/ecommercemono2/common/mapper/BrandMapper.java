package com.example.ecommercemono2.common.mapper;

import com.example.ecommercemono2.business.dto.request.brand.CreateBrandRequest;
import com.example.ecommercemono2.business.dto.request.brand.UpdateBrandRequest;
import com.example.ecommercemono2.entities.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class BrandMapper {
    public Brand createBrandRequestToBrand(CreateBrandRequest request) {
        Brand brand = new Brand();
        brand.setId(UUID.randomUUID());
        brand.setName(request.getName());
        return brand;
    }

    public Brand updateBrandRequestToBrand(UpdateBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());
        return brand;
    }
}
