package com.example.ecommercemono2.business.dto.request.cartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCartItemRequest {
    private UUID cartId;
    private UUID productId;
    private int quantity;
}