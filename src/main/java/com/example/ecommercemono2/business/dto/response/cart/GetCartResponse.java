package com.example.ecommercemono2.business.dto.response.cart;

import com.example.ecommercemono2.entities.Cart;
import com.example.ecommercemono2.entities.CartItem;
import com.example.ecommercemono2.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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
