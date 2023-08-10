package com.example.ecommercemono2.business.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllCartsResponse {
    private UUID id;
    private UUID userId;
    private double totalPrice;
    //private List<Product> cartItemProducts;
}
