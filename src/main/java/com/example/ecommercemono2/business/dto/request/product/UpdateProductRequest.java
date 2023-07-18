package com.example.ecommercemono2.business.dto.request.product;

import com.example.ecommercemono2.entities.enums.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateProductRequest {
    private String name;
    private int stock;
    private String information;
    private UUID brandId;
    private UUID categoryId;
    private Color color;

}
