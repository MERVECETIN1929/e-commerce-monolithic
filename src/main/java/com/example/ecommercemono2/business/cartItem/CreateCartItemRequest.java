package com.example.ecommercemono2.business.cartItem;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCartItemRequest {
    private UUID userId;
    private UUID productId;
    @Min(1)
    private int quantity;

}
