package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.cartItem.CartItemService;
import com.example.ecommercemono2.business.cartItem.CreateCartItemRequest;
import com.example.ecommercemono2.business.cartItem.UpdateCartItemRequest;
import com.example.ecommercemono2.business.cartItem.CreateCartItemResponse;
import com.example.ecommercemono2.business.cartItem.GetAllCartItemsResponse;
import com.example.ecommercemono2.business.cartItem.GetCartItemResponse;
import com.example.ecommercemono2.business.cartItem.UpdateCartItemResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cartItem")
public class CartItemController {
    // todo add http status code
    private final CartItemService service;

    @PostMapping
    @PreAuthorize("hasRole('USER') and #request.userId.equals(authentication.principal.id)")
    public CreateCartItemResponse add(@Valid @RequestBody CreateCartItemRequest request) {
        return service.add(request);
    }
    @PutMapping("/{id}")
    @PostAuthorize("returnObject.cartUserId.equals(authentication.principal.id)")
    //@PostAuthorize("returnObject.cartUserId==authentication.principal.id")
    public UpdateCartItemResponse update(@PathVariable UUID id, @Valid  @RequestBody UpdateCartItemRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetCartItemResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PutMapping("/increaseQuantity/{id}")
    public void increaseQuantity(@Valid @RequestBody CreateCartItemRequest request, @PathVariable UUID id) {
        service.increaseQuantity(request, id);
    }

    @PutMapping("/reduceQuantity/{id}")
    public void reduceQuantity(@Valid @RequestBody CreateCartItemRequest request, @PathVariable UUID id) {
        service.reduceQuantity(request, id);
    }
}
