package com.example.ecommercemono2.business.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}

