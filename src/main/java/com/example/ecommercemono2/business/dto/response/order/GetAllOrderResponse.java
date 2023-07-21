package com.example.ecommercemono2.business.dto.response.order;

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
public class GetAllOrderResponse {
    private String city;
    private String country;
    private int postCode;
    private String neighbourhood;
    private String street;
    private int flatsNumber;
    private int floorNumber;
    private LocalDate orderDate;
    private LocalDate arrivalDate;
    private double totalPrice;
    private List<OrderDetails> orderDetails;
}
