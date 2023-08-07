package com.example.ecommercemono2.business.dto.request.order;


import com.example.ecommercemono2.common.dto.AddressRequest;
import com.example.ecommercemono2.common.dto.PaymentRequest;
import com.example.ecommercemono2.entities.enums.PaymentType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;


}
