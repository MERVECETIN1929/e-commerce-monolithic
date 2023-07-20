package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.business.abstracts.BrandService;
import com.example.ecommercemono2.business.abstracts.CategoryService;
import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductRules {
    private final ProductRepository repository;
    private final BrandService brandService;
    private final CategoryService categoryService;

    public void existsProductById(UUID id) {
        if (!repository.existsProductById(id)) {
            throw new BusinessException(Message.Product.NotExistId);
        }
    }

    public void checkIfBrandExists(UUID brandId) {
        if (!brandService.checkIfBrandExist(brandId)) {
            throw new BusinessException(Message.Brand.NotExistId);
        }
    }

    public void checkIfCategoryExists(UUID categoryId) {
        if (!categoryService.checkIfCategoryExist(categoryId)) {
            throw new BusinessException(Message.Category.NotExistId);
        }
    }
    public void checkProductStock(UUID productId,int quantity){
        if (repository.findById(productId).orElseThrow().getStock()<quantity){
            throw new BusinessException(Message.Product.NoStock);
        }
    }
}
