package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.brand.CreateBrandRequest;
import com.example.ecommercemono2.business.dto.request.brand.UpdateBrandRequest;
import com.example.ecommercemono2.business.dto.response.brand.CreateBrandResponse;
import com.example.ecommercemono2.business.dto.response.brand.GetAllBrandsResponse;
import com.example.ecommercemono2.business.dto.response.brand.GetBrandResponse;
import com.example.ecommercemono2.business.dto.response.brand.UpdateBrandResponse;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    CreateBrandResponse add(CreateBrandRequest request);

    UpdateBrandResponse update(UUID brandId, UpdateBrandRequest request);

    GetBrandResponse getById(UUID brandId);

    List<GetAllBrandsResponse> getAll();

    void delete(UUID brandId);

    boolean checkIfBrandExist(UUID brandId);
}
