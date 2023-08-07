package com.example.ecommercemono2.business.dto.request.payment;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreatePaymentRequest {
    @NotBlank
    @Length(min=16,max=16)
    private String cardNumber;
    @NotBlank
    private String cardHolderName;
    @Min(000)
    @Max(999)
    private int cvv;
    @Min(2023)
    private int year;
    @Min(1)
    @Max(12)
    private int month;
    @Min(0)
    private double balance;
}
