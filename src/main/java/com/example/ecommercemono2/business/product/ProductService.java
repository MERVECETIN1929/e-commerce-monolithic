package com.example.ecommercemono2.business.product;


import com.example.ecommercemono2.entities.CartItem;
import com.example.ecommercemono2.entities.OrderDetails;

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
    void takeBackStock(List<OrderDetails> orderDetails);
}
