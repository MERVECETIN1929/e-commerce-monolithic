package com.example.ecommercemono2.business.dto.response.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UpdateCartResponse {
    private UUID id;
    private UUID userId;
}
