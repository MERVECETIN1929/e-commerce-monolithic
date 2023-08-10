package com.example.ecommercemono2.business.category;

import com.example.ecommercemono2.business.rules.CategoryRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Category;
import com.example.ecommercemono2.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final ModelMapperService mapper;
    private final CategoryRules rules;
    private final CategoryRepository repository;

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        rules.existByName(request.getName());
        Category category = mapper.forRequest().map(request, Category.class);
        category.setId(UUID.randomUUID());
        Category saveCategory = repository.save(category);
        return mapper.forResponse().map(saveCategory, CreateCategoryResponse.class);
    }

    @Override
    public UpdateCategoryResponse update(UUID categoryId, UpdateCategoryRequest request) {
        Category category = mapper.forRequest().map(request, Category.class);
        rules.existById(categoryId);
        rules.existByName(request.getName());
        category.setId(categoryId);
        var saveCategory = repository.save(category);
        return mapper.forResponse().map(saveCategory, UpdateCategoryResponse.class);
    }

    @Override
    public GetCategoryResponse getById(UUID categoryId) {
        rules.existById(categoryId);
        var category = repository.findById(categoryId).orElseThrow();
        return mapper.forResponse().map(category, GetCategoryResponse.class);
    }

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        return repository.findAll().stream()
                .map(category -> mapper.forResponse().map(category, GetAllCategoriesResponse.class)).toList();

    }

    @Override
    public void delete(UUID categoryId) {
        rules.existById(categoryId);
        repository.deleteById(categoryId);
    }

    @Override
    public boolean checkIfCategoryExist(UUID categoryId) {
        return repository.existsCategoryById(categoryId);
    }
}
