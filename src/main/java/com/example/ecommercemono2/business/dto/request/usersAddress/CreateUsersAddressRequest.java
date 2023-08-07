package com.example.ecommercemono2.business.dto.request.usersAddress;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUsersAddressRequest {
    @NotBlank
    private String city;
    @NotBlank
    private String country;
    @NotNull
    @Min(01000)
    @Max(81999)
    private int postCode;
    @NotBlank
    private String neighbourhood;
    @NotBlank
    private String street;
    @Min(1)
    private int flatsNumber;
    @Min(1)
    private int floorNumber;

}
