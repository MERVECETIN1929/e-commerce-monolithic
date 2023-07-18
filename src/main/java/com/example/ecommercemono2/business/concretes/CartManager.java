package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.CartService;
import com.example.ecommercemono2.business.dto.request.cart.CreateCartRequest;
import com.example.ecommercemono2.business.dto.request.cart.UpdateCartRequest;
import com.example.ecommercemono2.business.dto.response.cart.CreateCartResponse;
import com.example.ecommercemono2.business.dto.response.cart.GetAllCartsResponse;
import com.example.ecommercemono2.business.dto.response.cart.GetCartResponse;
import com.example.ecommercemono2.business.dto.response.cart.UpdateCartResponse;
import com.example.ecommercemono2.business.rules.CartRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Cart;
import com.example.ecommercemono2.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor

public class CartManager implements CartService {
    private final ModelMapperService mapper;
    private final CartRules rules;
    private final CartRepository repository;
    @Override
    public CreateCartResponse add(CreateCartRequest request) {
        Cart cart=mapper.forRequest().map(request,Cart.class);
        cart.setId(UUID.randomUUID());
        cart.setTotalPrice(0);
        var saveCart=repository.save(cart);
        return mapper.forResponse().map(saveCart, CreateCartResponse.class);
    }

    @Override
    // todo update içinde ne yapılabilir ki?
    public UpdateCartResponse update(UUID cartId, UpdateCartRequest request) {
        Cart cart=mapper.forRequest().map(getById(cartId),Cart.class);
        cart.setId(cartId);
        cart.setTotalPrice(request.getPrice());
        repository.save(cart);
        return mapper.forResponse().map(cart, UpdateCartResponse.class);
    }

    @Override
    public GetCartResponse getById(UUID cartId) {
        rules.existById(cartId);
        Cart cart=repository.findById(cartId).orElseThrow();
        return mapper.forResponse().map(cart, GetCartResponse.class);
    }

    @Override
    public List<GetAllCartsResponse> getAll() {
        return repository.findAll().stream()
               .map(cart->mapper.forResponse().map(cart, GetAllCartsResponse.class)).toList();
    }

    @Override
    public void delete(UUID cartId) {
        rules.existById(cartId);
        repository.deleteById(cartId);
    }

    @Override
    public void addPriceTotalPrice(double addPrice, UUID cartId) {
            rules.existById(cartId);
            Cart cart=mapper.forRequest().map(getById(cartId),Cart.class);
            cart.setTotalPrice(cart.getTotalPrice()+addPrice);
            cart.setId(cartId);
            repository.save(cart);
    }

    @Override
    public void minusPriceTotalPrice(double minusPrice, UUID cartId) {
        rules.existById(cartId);
        Cart cart=mapper.forRequest().map(getById(cartId),Cart.class);
        cart.setTotalPrice(cart.getTotalPrice()-minusPrice);
        cart.setId(cartId);
        repository.save(cart);
    }

    @Override
    public void changeTotalPrice() {

    }

}
