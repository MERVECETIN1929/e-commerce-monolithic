package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.cartItem.UpdateCartItemUnitPrice;
import com.example.ecommercemono2.business.dto.request.product.ChangeProductUnitPrice;

public interface CartItemProductService {
    void updateCartItemUnitPriceAntTotalPrice(UpdateCartItemUnitPrice updateCartItemUnitPrice);
}
