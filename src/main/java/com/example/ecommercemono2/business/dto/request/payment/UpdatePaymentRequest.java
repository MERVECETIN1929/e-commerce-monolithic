package com.example.ecommercemono2.business.dto.request.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdatePaymentRequest {
    private String cardNumber;
    private String cardHolderName;
    private int cvv;
    private int year;
    private int month;
    private double balance;
}
