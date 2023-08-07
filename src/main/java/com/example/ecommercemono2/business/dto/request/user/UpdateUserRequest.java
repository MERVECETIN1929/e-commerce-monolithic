package com.example.ecommercemono2.business.dto.request.user;

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
public class UpdateUserRequest {
    @NotBlank
    @Length(min=2,max=50)
    private String firstName;
    @NotBlank
    @Length(min=2,max=50)
    private String lastName;
    @NotBlank
    @Length(min=8,max=50)
    private String password;
}

