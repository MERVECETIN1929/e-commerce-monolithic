package com.example.ecommercemono2.business.dto.request.brand;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateBrandRequest {
    @NotBlank
    @Length(min=2,max=75)
    private String name;
}
