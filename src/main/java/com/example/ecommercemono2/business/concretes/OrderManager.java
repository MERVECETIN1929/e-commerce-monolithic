package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.*;
import com.example.ecommercemono2.business.dto.request.order.CreateOrderRequest;
import com.example.ecommercemono2.business.rules.PaymentRules;
import com.example.ecommercemono2.business.rules.UserRules;
import com.example.ecommercemono2.common.dto.payment.OrderPaymentRequest;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Cart;
import com.example.ecommercemono2.entities.Order;
import com.example.ecommercemono2.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository repository;
    private final UserRules userRules;
    private final CartService cartService;
    private final ModelMapperService mapper;
    private final OrderDetailsService orderDetailsService;
    private final CartItemService cartItemService;
    private final ProductService productService;
    private final PaymentService paymentService;
    @Override
    public void add(CreateOrderRequest request) {
        userRules.checkIfExistUserById(request.getUserId());
        Cart cart=cartService.getCartByUserId(request.getUserId());
        OrderPaymentRequest orderPaymentRequest=mapper.forRequest().map(request.getPaymentRequest(), OrderPaymentRequest.class);
        orderPaymentRequest.setTotalPrice(cart.getTotalPrice());
        Order order=mapper.forRequest().map(request,Order.class);
        order.setOrderDate(LocalDate.now());
        order.setTotalPrice(cart.getTotalPrice());
        order.setId(null);
        order.setCity(request.getAddressRequest().getCity());
        order.setCountry(request.getAddressRequest().getCountry());
        order.setStreet(request.getAddressRequest().getStreet());
        order.setNeighbourhood(request.getAddressRequest().getNeighbourhood());
        order.setFlatsNumber(request.getAddressRequest().getFlatsNumber());
        order.setFloorNumber(request.getAddressRequest().getFloorNumber());
        order.setFloorNumber(request.getAddressRequest().getFloorNumber());
        productService.checkProductStock(cartItemService.getAllCartItemsByCartId(cart.getId()));
        paymentService.pay(orderPaymentRequest);
        productService.dropOutOfStock(cartItemService.getAllCartItemsByCartId(cart.getId()));
        Order saveOrder=repository.save(order);
        orderDetailsService.addOrderDetailsByCartId(cart.getId(),saveOrder);
        cartService.clearCart(cart.getId());
        cartItemService.deleteAllByCartId(cart.getId());
    }

    @Override
    public void cancel(UUID userId, UUID orderId) {
        System.err.println("deneme");
    }
}
