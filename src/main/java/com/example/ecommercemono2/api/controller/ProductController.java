package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.ProductService;
import com.example.ecommercemono2.business.dto.request.product.ChangeProductUnitPrice;
import com.example.ecommercemono2.business.dto.request.product.CreateProductRequest;
import com.example.ecommercemono2.business.dto.request.product.UpdateProductRequest;
import com.example.ecommercemono2.business.dto.response.product.CreateProductResponse;
import com.example.ecommercemono2.business.dto.response.product.GetAllProductsResponse;
import com.example.ecommercemono2.business.dto.response.product.GetProductResponse;
import com.example.ecommercemono2.business.dto.response.product.UpdateProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService service;
    @PostMapping
    public CreateProductResponse add(@RequestBody CreateProductRequest request){
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable UUID id,@RequestBody UpdateProductRequest request){
        return service.update(id,request);
    }
    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @GetMapping
    public List<GetAllProductsResponse> getAll(){
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
    @PutMapping("/change-product-unit-price/{id}")
    public void changeProductUnitPrice(@PathVariable UUID id,@RequestBody ChangeProductUnitPrice changeProductUnitPrice) {
        service.changeProductUnitPrice(id,changeProductUnitPrice);
    }
}
