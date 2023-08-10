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
public class GetCartResponse {
    private UUID id;
    private UUID userId;
    private double totalPrice;
    //  list yapınca neden jsona döndüremedi araştır: cartItemde cart var cartta cart item var sonsuz döngüye girdi
    //private List<Product> cartItemProducts;
}
