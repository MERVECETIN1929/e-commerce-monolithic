package com.example.ecommercemono2.business.dto.request.category;

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
public class CreateCategoryRequest {
    @NotBlank
    @Length(min=2,max=100)
    private String name;
}
