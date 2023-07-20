package com.example.ecommercemono2.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddressRequest {
    private String city;
    private String country;
    private int postCode;
    private String neighbourhood;
    private String street;
    private int flatsNumber;
    private int floorNumber;
}
