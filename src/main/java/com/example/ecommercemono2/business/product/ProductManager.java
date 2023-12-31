package com.example.ecommercemono2.business.product;


import com.example.ecommercemono2.business.cartItem.UpdateCartItemUnitPrice;
import com.example.ecommercemono2.business.rules.ProductRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.CartItem;
import com.example.ecommercemono2.entities.OrderDetails;
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
        Product product = mapper.forRequest().map(request, Product.class);
        product.setId(null);
        repository.save(product);
        return mapper.forResponse().map(product, CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse update(UUID productId, UpdateProductRequest request) {
        rules.existsProductById(productId);
        Product product = mapper.forRequest().map(request, Product.class);
        product.setId(productId);
        repository.save(product);
        return mapper.forResponse().map(product, UpdateProductResponse.class);
    }

    @Override
    public GetProductResponse getById(UUID productId) {
        rules.existsProductById(productId);
        Product product = repository.findById(productId).orElseThrow();
        return mapper.forResponse().map(product, GetProductResponse.class);
    }

    @Override
    public List<GetAllProductsResponse> getAll() {
        return repository.findAll().stream().map(product -> mapper.forResponse().map(product, GetAllProductsResponse.class)).toList();
    }

    @Override
    public void delete(UUID productId) {
        rules.existsProductById(productId);
        repository.deleteById(productId);
    }

    @Override
    public void changeProductUnitPrice(UUID productId, ChangeProductUnitPrice changeProductUnitPrice) {
        rules.existsProductById(productId);
        Product product = mapper.forRequest().map(getById(productId), Product.class);
        product.setUnitPrice(changeProductUnitPrice.getUnitPrice());
        product.setId(productId);
        UpdateCartItemUnitPrice updateCartItemUnitPrice = new UpdateCartItemUnitPrice();
        updateCartItemUnitPrice.setProductId(productId);
        updateCartItemUnitPrice.setUnitPrice(changeProductUnitPrice.getUnitPrice());
        repository.save(product);
    }

    @Override
    public void checkProductStock(List<CartItem> cartItems) {
        for (CartItem cartItem:cartItems){
            rules.checkProductStock(cartItem.getProduct().getId(),cartItem.getQuantity());
        }
    }

    @Override
    public void dropOutOfStock(List<CartItem> cartItems) {
        for (CartItem cartItem:cartItems){
            Product product=mapper.forResponse().map(getById(cartItem.getProduct().getId()),Product.class);
            product.setStock(product.getStock()-cartItem.getQuantity());
            repository.save(product);
        }
    }

    @Override
    public void takeBackStock(List<OrderDetails> orderDetailsList) {
        for (OrderDetails orderDetails:orderDetailsList){
            Product product=mapper.forRequest().map(getById(orderDetails.getProductId()),Product.class);
            product.setStock(orderDetails.getQuantity()+product.getStock());
            repository.save(product);
        }
    }

    private double priceAfterDiscount(double price, int discount) {
        return price - ((price * discount) / 100);
    }
}
