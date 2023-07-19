package com.example.ecommercemono2.business.dto.response.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetAllPaymentsResponse {
    private UUID id;
    private String cardNumber;
    private String cardHolderName;
    private int cvv;
    private int year;
    private int month;
    private double balance;
}
