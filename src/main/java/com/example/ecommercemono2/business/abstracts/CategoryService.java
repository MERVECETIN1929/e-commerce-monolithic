package com.example.ecommercemono2.business.abstracts;



import com.example.ecommercemono2.business.dto.request.category.CreateCategoryRequest;
import com.example.ecommercemono2.business.dto.request.category.UpdateCategoryRequest;
import com.example.ecommercemono2.business.dto.response.category.CreateCategoryResponse;
import com.example.ecommercemono2.business.dto.response.category.GetAllCategoriesResponse;
import com.example.ecommercemono2.business.dto.response.category.GetCategoryResponse;
import com.example.ecommercemono2.business.dto.response.category.UpdateCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(UUID CategoryId, UpdateCategoryRequest request);
    GetCategoryResponse getById(UUID categoryId);
    List<GetAllCategoriesResponse> getAll();
    void delete(UUID categoryId);
    boolean checkIfCategoryExist(UUID categoryId);
}
