package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.cartItem.CreateCartItemRequest;
import com.example.ecommercemono2.business.dto.request.cartItem.UpdateCartItemRequest;
import com.example.ecommercemono2.business.dto.request.cartItem.UpdateCartItemUnitPrice;
import com.example.ecommercemono2.business.dto.response.cartItem.CreateCartItemResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.GetAllCartItemsResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.GetCartItemResponse;
import com.example.ecommercemono2.business.dto.response.cartItem.UpdateCartItemResponse;
import com.example.ecommercemono2.entities.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartItemService {
    CreateCartItemResponse add(CreateCartItemRequest request);
    UpdateCartItemResponse update(UUID CartItemId, UpdateCartItemRequest request);
    GetCartItemResponse getById(UUID cartItemId);
    List<GetAllCartItemsResponse> getAll();
    void delete(UUID cartItemId);
    void increaseQuantity(CreateCartItemRequest request,UUID cartId);
    void reduceQuantity(CreateCartItemRequest request,UUID cartId);
    void updateCartItemUnitPriceAntTotalPrice(UpdateCartItemUnitPrice updateCartItemUnitPrice);
}
