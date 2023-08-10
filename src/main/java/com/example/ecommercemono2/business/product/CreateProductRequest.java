package com.example.ecommercemono2.business.product;

import com.example.ecommercemono2.entities.enums.Color;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProductRequest {
    @NotBlank
    @Length(min=1,max=100)
    private String name;
    @Min(1)
    private double unitPrice;
    @Min(1)
    private int stock;
    @NotBlank
    @Length(min=10,max=500)
    private String information;
    private UUID brandId;
    private UUID categoryId;
    private Color color;

}
