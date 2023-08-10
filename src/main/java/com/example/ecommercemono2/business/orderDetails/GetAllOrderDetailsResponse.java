package com.example.ecommercemono2.business.orderDetails;

import com.example.ecommercemono2.entities.enums.Color;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllOrderDetailsResponse {
    private UUID id;
    private String name;
    private double unitPrice;
    private String information;
    @Enumerated(EnumType.STRING)
    private Color color;
    private String categoryName;
    private String brandName;
    private int quantity;
    private double totalPrice;
    private UUID orderId;
    private UUID productId;
    private UUID userId;
}
