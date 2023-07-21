package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.CartItemService;
import com.example.ecommercemono2.business.abstracts.OrderDetailsService;
import com.example.ecommercemono2.business.dto.response.orderDetails.GetAllOrderDetailsResponse;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.CartItem;
import com.example.ecommercemono2.entities.Order;
import com.example.ecommercemono2.entities.OrderDetails;
import com.example.ecommercemono2.repository.OrderDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
            orderDetails.setProductId(cartItem.getProduct().getId());
            repository.save(orderDetails);
        }
    }

    @Override
    public List<GetAllOrderDetailsResponse> getAllOrderDetailsByOrderId(UUID orderId) {
        return repository.findAllByOrderId(orderId).stream()
                .map(orderDetails -> mapper.forResponse().map(orderDetails,GetAllOrderDetailsResponse.class)).collect(Collectors.toList());
    }
}
