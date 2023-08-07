package com.example.ecommercemono2.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Invoice {
    @Id
    private UUID id;
    List<OrderDetails> orderDetails;
    private UUID userId;
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
    private LocalDate invoiceDate;
}
