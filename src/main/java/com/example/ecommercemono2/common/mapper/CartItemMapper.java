package com.example.ecommercemono2.common.mapper;

import com.example.ecommercemono2.business.abstracts.CartService;
import com.example.ecommercemono2.business.abstracts.ProductService;
import com.example.ecommercemono2.business.dto.request.cartItem.CreateCartItemRequest;
import com.example.ecommercemono2.business.dto.request.cartItem.UpdateCartItemRequest;
import com.example.ecommercemono2.entities.Cart;
import com.example.ecommercemono2.entities.CartItem;
import com.example.ecommercemono2.entities.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CartItemMapper {
    private final CartService cartService;
    private final ProductService productService;
    private final ModelMapper mapper;
    // todo cartItemUnitPrice get product
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
