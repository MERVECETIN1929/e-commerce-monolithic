package com.example.ecommercemono2.business.cartItem;

import com.example.ecommercemono2.entities.CartItem;

import java.util.List;
import java.util.UUID;

public interface CartItemService {
    CreateCartItemResponse add(CreateCartItemRequest request);

    UpdateCartItemResponse update(UUID CartItemId, UpdateCartItemRequest request);

    GetCartItemResponse getById(UUID cartItemId);

    List<GetAllCartItemsResponse> getAll();
    List<CartItem> getAllCartItemsByCartId(UUID cartId);

    void delete(UUID cartItemId);

    void increaseQuantity(CreateCartItemRequest request, UUID cartId);

    void reduceQuantity(CreateCartItemRequest request, UUID cartId);
    void deleteAllByCartId(UUID cartId);

    void updateCartItemUnitPriceAntTotalPrice(UpdateCartItemUnitPrice updateCartItemUnitPrice);
}
