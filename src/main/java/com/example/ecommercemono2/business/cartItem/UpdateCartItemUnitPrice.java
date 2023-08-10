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
public class UpdateCartItemUnitPrice {
    private UUID productId;
    private double unitPrice;
}
