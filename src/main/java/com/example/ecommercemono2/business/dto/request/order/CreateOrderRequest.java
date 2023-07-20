package com.example.ecommercemono2.business.dto.request.order;

import com.example.ecommercemono2.common.dto.AddressRequest;
import com.example.ecommercemono2.common.dto.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateOrderRequest {
    private AddressRequest addressRequest;
    private PaymentRequest paymentRequest;
    private UUID userId;
    // todo 4 alanı kendin setler
    /*private LocalDate orderDate;
    private LocalDate preparationDate;
     private double totalPrice;
    */
    //private boolean isPreparation;

}
