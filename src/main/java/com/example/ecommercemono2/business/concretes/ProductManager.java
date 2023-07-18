package com.example.ecommercemono2.business.concretes;


import com.example.ecommercemono2.business.abstracts.ProductService;
import com.example.ecommercemono2.business.dto.request.cartItem.UpdateCartItemUnitPrice;
import com.example.ecommercemono2.business.dto.request.product.ChangeProductUnitPrice;
import com.example.ecommercemono2.business.dto.request.product.CreateProductRequest;
import com.example.ecommercemono2.business.dto.request.product.UpdateProductRequest;
import com.example.ecommercemono2.business.dto.response.product.CreateProductResponse;
import com.example.ecommercemono2.business.dto.response.product.GetAllProductsResponse;
import com.example.ecommercemono2.business.dto.response.product.GetProductResponse;
import com.example.ecommercemono2.business.dto.response.product.UpdateProductResponse;
import com.example.ecommercemono2.business.rules.ProductRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Product;
import com.example.ecommercemono2.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final ProductRules rules;
    private final ModelMapperService mapper;


    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        rules.checkIfBrandExists(request.getBrandId());
        rules.checkIfCategoryExists(request.getCategoryId());
        Product product=mapper.forRequest().map(request,Product.class);
        product.setId(null);
        repository.save(product);
        return mapper.forResponse().map(product, CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse update(UUID productId, UpdateProductRequest request) {
        rules.existsProductById(productId);
        Product product=mapper.forRequest().map(request,Product.class);
        product.setId(productId);
        repository.save(product);
        return mapper.forResponse().map(product, UpdateProductResponse.class);
    }

    @Override
    public GetProductResponse getById(UUID productId) {
        rules.existsProductById(productId);
        Product product=repository.findById(productId).orElseThrow();
        return mapper.forResponse().map(product,GetProductResponse.class);
    }

    @Override
    public List<GetAllProductsResponse> getAll() {
        return repository.findAll().stream().map(product->mapper.forResponse().map(product,GetAllProductsResponse.class)).toList();
    }

    @Override
    public void delete(UUID productId) {
        rules.existsProductById(productId);
        repository.deleteById(productId);
    }

    @Override
    public void changeProductUnitPrice(UUID productId, ChangeProductUnitPrice changeProductUnitPrice) {
        rules.existsProductById(productId);
        Product product=mapper.forRequest().map(getById(productId),Product.class);
        product.setUnitPrice(changeProductUnitPrice.getUnitPrice());
        product.setId(productId);
        UpdateCartItemUnitPrice updateCartItemUnitPrice=new UpdateCartItemUnitPrice();
        updateCartItemUnitPrice.setProductId(productId);
        updateCartItemUnitPrice.setUnitPrice(changeProductUnitPrice.getUnitPrice());
        repository.save(product);
    }

    private double priceAfterDiscount(double price,int discount){
        return price-((price*discount)/100);
    }
}
