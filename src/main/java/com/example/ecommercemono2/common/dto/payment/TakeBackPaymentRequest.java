package com.example.ecommercemono2.common.dto.payment;

import com.example.ecommercemono2.common.dto.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TakeBackPaymentRequest extends PaymentRequest {
    private double takeBackPrice;
}
