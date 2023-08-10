package com.example.ecommercemono2.business.cartItem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCartItemResponse {
    private UUID id;
    private UUID cartId;
    private UUID productId;
    private double productUnitPrice;
    private int quantity;
    private double totalPrice;

}

