package com.example.ecommercemono2.business.abstracts;


import com.example.ecommercemono2.business.dto.request.product.ChangeProductUnitPrice;
import com.example.ecommercemono2.business.dto.request.product.CreateProductRequest;
import com.example.ecommercemono2.business.dto.request.product.UpdateProductRequest;
import com.example.ecommercemono2.business.dto.response.product.CreateProductResponse;
import com.example.ecommercemono2.business.dto.response.product.GetAllProductsResponse;
import com.example.ecommercemono2.business.dto.response.product.GetProductResponse;
import com.example.ecommercemono2.business.dto.response.product.UpdateProductResponse;
import com.example.ecommercemono2.entities.CartItem;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    CreateProductResponse add(CreateProductRequest request);

    UpdateProductResponse update(UUID productId, UpdateProductRequest request);

    GetProductResponse getById(UUID productId);

    List<GetAllProductsResponse> getAll();

    void delete(UUID productId);

    void changeProductUnitPrice(UUID productId, ChangeProductUnitPrice changeProductUnitPrice);
    void checkProductStock(List<CartItem> cartItems);
    void dropOutOfStock(List<CartItem> cartItems);
}
