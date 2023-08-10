package com.example.ecommercemono2.business.invoice;

import com.example.ecommercemono2.entities.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateInvoiceResponse {
    List<OrderDetails> orderDetails;
    private double totalPrice;
    private String city;
    private String country;
    private int postCode;
    private String neighbourhood;
    private String street;
    private int flatsNumber;
    private int floorNumber;
    private LocalDate orderDate;
    private String cardHolderName;
    private String firstName;
    private String lastName;
    private String email;
}
