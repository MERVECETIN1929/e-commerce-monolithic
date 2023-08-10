package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.admin.LoginAdminRequest;
import com.example.ecommercemono2.business.admin.LoginAdminResponse;
import com.example.ecommercemono2.business.user.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private final UserService service;
    @PostMapping("/login")
    public LoginUserResponse login(@Valid @RequestBody LoginUserRequest request) {
        return service.login(request);
    }
    @PostMapping("/admin/login")
    public LoginAdminResponse loginAdmin(@Valid @RequestBody LoginAdminRequest request) {
        return service.loginAdmin(request);
    }
    @PostMapping
    public CreateUserResponse add(@Valid @RequestBody CreateUserRequest request) {
        return service.add(request);
    }

}
