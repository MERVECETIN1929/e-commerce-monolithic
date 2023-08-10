package com.example.ecommercemono2.business.category;


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
