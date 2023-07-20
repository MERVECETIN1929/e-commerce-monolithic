package com.example.ecommercemono2.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequest {
    private String cardNumber;
    private String cardHolderName;
    private int cvv;
    private int year;
    private int month;
}
