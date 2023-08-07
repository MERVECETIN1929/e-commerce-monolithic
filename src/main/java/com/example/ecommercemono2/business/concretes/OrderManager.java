package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.*;
import com.example.ecommercemono2.business.dto.request.invoice.CreateInvoiceRequest;
import com.example.ecommercemono2.business.dto.request.order.CreateOrderRequest;
import com.example.ecommercemono2.business.dto.response.order.GetAllOrderResponse;
import com.example.ecommercemono2.business.dto.response.order.GetOrderResponse;
import com.example.ecommercemono2.business.dto.response.user.GetUserResponse;
import com.example.ecommercemono2.business.rules.OrderRules;
import com.example.ecommercemono2.business.rules.UserRules;
import com.example.ecommercemono2.common.dto.PaymentRequest;
import com.example.ecommercemono2.common.dto.payment.OrderPaymentRequest;
import com.example.ecommercemono2.common.dto.payment.TakeBackPaymentRequest;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Cart;
import com.example.ecommercemono2.entities.CartItem;
import com.example.ecommercemono2.entities.Order;
import com.example.ecommercemono2.entities.OrderDetails;
import com.example.ecommercemono2.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderManager implements OrderService {
    private final OrderRepository repository;
    private final UserRules userRules;
    private final UserService userService;
    private final CartService cartService;
    private final ModelMapperService mapper;
    private final OrderDetailsService orderDetailsService;
    private final CartItemService cartItemService;
    private final ProductService productService;
    private final OrderRules rules;
    private final InvoiceService invoiceService;
    private final ApplicationContext applicationContext;
    private final PaymentService paymentService;
    private  PayService payService;
    private final Queue<CreateOrderRequest> queue=new LinkedList<>();


    private void add(CreateOrderRequest request) {
        userRules.checkIfExistUserById(request.getUserId());
        payService=applicationContext.getBean(request.getPaymentType().toString(),PayService.class);

        Cart cart=cartService.getCartByUserId(request.getUserId());
        List<CartItem> cardItemList=cartItemService.getAllCartItemsByCartId(cart.getId());

        OrderPaymentRequest orderPaymentRequest=mapper.forRequest().map(request.getPaymentRequest(), OrderPaymentRequest.class);
        orderPaymentRequest.setTotalPrice(cart.getTotalPrice());

        Order order=getOrder(request);
        order.setTotalPrice(cart.getTotalPrice());

        productService.checkProductStock(cardItemList);
        order.setItPaid(payService.pay(orderPaymentRequest));
        productService.dropOutOfStock(cardItemList);
        Order saveOrder=repository.save(order);

        orderDetailsService.addOrderDetailsByCartId(cart.getId(),saveOrder);

        CreateInvoiceRequest createInvoiceRequest=getCreateInvoiceRequest(request,saveOrder.getId());
        createInvoiceRequest.setTotalPrice(cart.getTotalPrice());
        invoiceService.add(createInvoiceRequest);

        cartService.clearCart(cart.getId());
        cartItemService.deleteAllByCartId(cart.getId());

        queue.poll();
    }

    @Override
    public void cancel(UUID userId, UUID orderId, PaymentRequest request) {
        userRules.checkIfExistUserById(userId);
        rules.checkIfOrderExist(orderId);
        Order order=mapper.forRequest().map(getById(orderId),Order.class);
        if(order.isItPaid()){
            payBack(request, order);
        }
        productService.takeBackStock(getById(orderId).getOrderDetails());
        repository.deleteById(orderId);
    }

    private void payBack(PaymentRequest request, Order order) {
        TakeBackPaymentRequest takeBackPaymentRequest=mapper.forRequest().map(request, TakeBackPaymentRequest.class);
        takeBackPaymentRequest.setTakeBackPrice(order.getTotalPrice());
        paymentService.takeBackPayment(takeBackPaymentRequest);
    }

    @Override
    public List<GetAllOrderResponse> getAll() {
        return repository.findAll().stream().map(order->mapper.forResponse().map(order, GetAllOrderResponse.class)).toList();
    }

    @Override
    public List<GetAllOrderResponse> getAll(UUID userId) {
        return repository.findAllByUserId(userId).stream().map(order -> mapper.forResponse().map(order,GetAllOrderResponse.class)).toList();
    }

    @Override
    public GetOrderResponse getById(UUID id) {
        rules.checkIfOrderExist(id);
        return mapper.forResponse().map(repository.findById(id).orElseThrow(), GetOrderResponse.class);
    }

    @Override
    public void addRequest(CreateOrderRequest request) {
        queue.add(request);
        add(request);
    }

    private Order getOrder(CreateOrderRequest request){
        Order order=mapper.forRequest().map(request,Order.class);
        order.setOrderDate(LocalDate.now());
        order.setId(null);
        order.setCity(request.getAddressRequest().getCity());
        order.setCountry(request.getAddressRequest().getCountry());
        order.setStreet(request.getAddressRequest().getStreet());
        order.setNeighbourhood(request.getAddressRequest().getNeighbourhood());
        order.setFlatsNumber(request.getAddressRequest().getFlatsNumber());
        order.setFloorNumber(request.getAddressRequest().getFloorNumber());
        order.setFloorNumber(request.getAddressRequest().getFloorNumber());
        order.setPreparation(false);
        return order;
    }
    private CreateInvoiceRequest getCreateInvoiceRequest(CreateOrderRequest request,UUID orderId){
        GetUserResponse user=userService.getById(request.getUserId());
        CreateInvoiceRequest createInvoiceRequest=new CreateInvoiceRequest();
        createInvoiceRequest.setCity(request.getAddressRequest().getCity());
        createInvoiceRequest.setEmail(user.getEmail());
        createInvoiceRequest.setCountry(request.getAddressRequest().getCountry());
        createInvoiceRequest.setNeighbourhood(request.getAddressRequest().getNeighbourhood());
        createInvoiceRequest.setFirstName(user.getFirstName());
        createInvoiceRequest.setFlatsNumber(request.getAddressRequest().getFlatsNumber());
        createInvoiceRequest.setOrderDetails(orderDetailsService.getAllOrderDetailsByOrderId(orderId).stream()
        .map(orderDetail-> mapper.forRequest().map(orderDetail, OrderDetails.class)).toList());
        createInvoiceRequest.setStreet(request.getAddressRequest().getStreet());
        createInvoiceRequest.setFloorNumber(request.getAddressRequest().getFloorNumber());
        createInvoiceRequest.setLastName(user.getLastName());
        createInvoiceRequest.setOrderDate(LocalDate.now());
        Optional<String> deneme=Optional.ofNullable(request.getPaymentRequest().getCardHolderName());
        createInvoiceRequest.setCardHolderName(deneme.orElse(null));
        createInvoiceRequest.setPostCode(request.getAddressRequest().getPostCode());
        createInvoiceRequest.setUserId(request.getUserId());
        return createInvoiceRequest;
    }

}
