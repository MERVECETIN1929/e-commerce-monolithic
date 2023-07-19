package com.example.ecommercemono2.common.mapper;

import com.example.ecommercemono2.business.abstracts.CartService;
import com.example.ecommercemono2.business.abstracts.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartItemMapper {
    private final CartService cartService;
    private final ProductService productService;
    private final ModelMapper mapper;

   /* public CartItem createCArtItemRequestToCartItem(CreateCartItemRequest request){
        CartItem cartItem=new CartItem();
        cartItem.setId(UUID.randomUUID());
        cartItem.setQuantity(request.getQuantity());
        Cart cart=mapper.map(cartService.getById(request.getCartId()),Cart.class);
        cartItem.setCart(cart);
        cartItem.setUnitPrice(request.getUnitPrice());
        Product product=mapper.map(productService.getById(request.getProductId()),Product.class);
        cartItem.setProduct(product);
        return cartItem;
    }*/
    /*public CartItem updateCArtItemRequestToCartItem(UpdateCartItemRequest request){
        CartItem cartItem=new CartItem();
        cartItem.setQuantity(request.getQuantity());
        Cart cart=mapper.map(cartService.getById(request.getCartId()),Cart.class);
        cartItem.setCart(cart);
        cartItem.setUnitPrice(request.getUnitPrice());
        Product product=mapper.map(productService.getById(request.getProductId()),Product.class);
        cartItem.setProduct(product);
        return cartItem;
    }*/
}
