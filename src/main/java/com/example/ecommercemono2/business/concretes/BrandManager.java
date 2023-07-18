package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.BrandService;

import com.example.ecommercemono2.business.dto.request.brand.CreateBrandRequest;
import com.example.ecommercemono2.business.dto.request.brand.UpdateBrandRequest;
import com.example.ecommercemono2.business.dto.response.brand.CreateBrandResponse;
import com.example.ecommercemono2.business.dto.response.brand.GetAllBrandsResponse;
import com.example.ecommercemono2.business.dto.response.brand.GetBrandResponse;
import com.example.ecommercemono2.business.dto.response.brand.UpdateBrandResponse;
import com.example.ecommercemono2.business.rules.BrandRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Brand;
import com.example.ecommercemono2.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
    private final ModelMapperService mapper;
    private final BrandRules rules;
    private final BrandRepository repository;
    @Override
    public CreateBrandResponse add(CreateBrandRequest request) {
        rules.existByName(request.getName());
        Brand brand=mapper.forRequest().map(request,Brand.class);
        brand.setId(UUID.randomUUID());
        Brand saveBrand=repository.save(brand);
        return mapper.forResponse().map(saveBrand,CreateBrandResponse.class);
    }

    @Override
    public UpdateBrandResponse update(UUID brandId, UpdateBrandRequest request) {
        Brand brand=mapper.forRequest().map(request,Brand.class);
        rules.existById(brandId);
        rules.existByName(request.getName());
        brand.setId(brandId);
        var saveBrand=repository.save(brand);
        return mapper.forResponse().map(saveBrand,UpdateBrandResponse.class);
    }

    @Override
    public GetBrandResponse getById(UUID brandId) {
        rules.existById(brandId);
        Brand brand=repository.findById(brandId).orElseThrow();

        return mapper.forResponse().map(brand,GetBrandResponse.class);
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        return repository.findAll().stream()
                .map(brand-> mapper.forResponse().map(brand,GetAllBrandsResponse.class)).toList();

    }

    @Override
    public void delete(UUID BrandId) {
        rules.existById(BrandId);
        repository.deleteById(BrandId);
    }

    @Override
    public boolean checkIfBrandExist(UUID brandId) {
        return repository.existsBrandById(brandId);
    }
}
