package com.example.ecommercemono2.business.brand;

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
