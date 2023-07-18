package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.CartService;
import com.example.ecommercemono2.business.dto.request.cart.CreateCartRequest;
import com.example.ecommercemono2.business.dto.request.cart.UpdateCartRequest;
import com.example.ecommercemono2.business.dto.response.cart.CreateCartResponse;
import com.example.ecommercemono2.business.dto.response.cart.GetAllCartsResponse;
import com.example.ecommercemono2.business.dto.response.cart.GetCartResponse;
import com.example.ecommercemono2.business.dto.response.cart.UpdateCartResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@RestController
@RequestMapping("/api/cart")
public class CartController {
    // todo add http status code
    // todo mapper failed
    // todo cretaecartItemden price kaldır
    private final CartService service;
    @PostMapping
    public CreateCartResponse add(@RequestBody CreateCartRequest request){
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateCartResponse update(@PathVariable UUID id, @RequestBody UpdateCartRequest request){
        return service.update(id,request);
    }
    @GetMapping("/{id}")
    public GetCartResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @GetMapping
    public List<GetAllCartsResponse> getAll(){
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
