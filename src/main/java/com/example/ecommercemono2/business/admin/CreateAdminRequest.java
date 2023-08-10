package com.example.ecommercemono2.business.admin;

import jakarta.validation.constraints.Email;
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
public class CreateAdminRequest {
    @NotBlank
    @Length(min=2,max=50)
    private String firstName;
    @NotBlank
    @Length(min=2,max=50)
    private String lastName;
    @Email
    private String email;
    @NotBlank
    @Length(min=8,max=50)
    private String password;

}
