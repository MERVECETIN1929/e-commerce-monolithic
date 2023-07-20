package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.CartItemService;
import com.example.ecommercemono2.business.abstracts.OrderDetailsService;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.CartItem;
import com.example.ecommercemono2.entities.Order;
import com.example.ecommercemono2.entities.OrderDetails;
import com.example.ecommercemono2.repository.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderDetailsManager implements OrderDetailsService {
    private final OrderDetailsRepository repository;
    private final CartItemService cartItemService;
    private  final ModelMapperService mapper;

    @Override
    public void addOrderDetailsByCartId(UUID cartId, Order order) {

        List<CartItem> cartItemList=cartItemService.getAllCartItemsByCartId(cartId);
        for (CartItem cartItem:cartItemList){
            OrderDetails orderDetails=mapper.forResponse().map(cartItem,OrderDetails.class);
            orderDetails.setId(null);
            orderDetails.setOrder(order);

            repository.save(orderDetails);
        }
    }
}
