package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.CartItemService;
import com.example.ecommercemono2.business.dto.request.cartItem.CreateCartItemRequest;
import com.example.ecommercemono2.business.dto.request.cartItem.UpdateCartItemRequest;
import com.example.ecommercemono2.business.dto.response.cartItem.CreateCartItemResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.GetAllCartItemsResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.GetCartItemResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.UpdateCartItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {// todo add http status code
    private final CartItemService service;

    @PostMapping
    public CreateCartItemResponse add(@RequestBody CreateCartItemRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCartItemResponse update(@PathVariable UUID id, @RequestBody UpdateCartItemRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetCartItemResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllCartItemsResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PutMapping("/increaseQuantity/{id}")
    public void increaseQuantity(@RequestBody CreateCartItemRequest request, @PathVariable UUID id) {
        service.increaseQuantity(request, id);
    }

    @PutMapping("/reduceQuantity/{id}")
    public void reduceQuantity(@RequestBody CreateCartItemRequest request, @PathVariable UUID id) {
        service.reduceQuantity(request, id);
    }
}
