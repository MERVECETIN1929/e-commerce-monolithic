package com.example.ecommercemono2.common.mapper;

import com.example.ecommercemono2.business.abstracts.UserService;
import com.example.ecommercemono2.business.dto.request.cart.CreateCartRequest;
import com.example.ecommercemono2.business.dto.request.cart.UpdateCartRequest;
import com.example.ecommercemono2.entities.Cart;
import com.example.ecommercemono2.entities.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CartMapper {
    private final ModelMapper mapper;
    private final UserService userService;

    public Cart createCartRequestToCart(CreateCartRequest request) {
        Cart cart = new Cart();
        User user = mapper.map(userService.getById(request.getUserId()), User.class);
        cart.setId(UUID.randomUUID());
        cart.setUser(user);
        return cart;
    }

    public Cart updateCartRequestToCart(UpdateCartRequest request) {
        Cart cart = new Cart();
        cart.setTotalPrice(request.getPrice());
        return cart;
    }
}
