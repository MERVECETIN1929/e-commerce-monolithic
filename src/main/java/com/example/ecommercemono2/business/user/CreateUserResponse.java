package com.example.ecommercemono2.business.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String token;
}

