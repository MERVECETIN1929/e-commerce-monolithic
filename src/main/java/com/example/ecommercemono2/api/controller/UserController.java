package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.UserService;
import com.example.ecommercemono2.business.dto.request.admin.LoginAdminRequest;
import com.example.ecommercemono2.business.dto.request.user.CreateUserRequest;
import com.example.ecommercemono2.business.dto.request.user.LoginUserRequest;
import com.example.ecommercemono2.business.dto.request.user.UpdateUserRequest;
import com.example.ecommercemono2.business.dto.response.admin.LoginAdminResponse;
import com.example.ecommercemono2.business.dto.response.user.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    @PostMapping
    public CreateUserResponse add(@Valid @RequestBody CreateUserRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateUserResponse update(@PathVariable UUID id,@Valid  @RequestBody UpdateUserRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetUserResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllUsersResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
    @PostMapping("/login")
    public LoginUserResponse login(@Valid @RequestBody LoginUserRequest request) {
        return service.login(request);
    }
    @PostMapping("/admin/login")
    public LoginAdminResponse loginAdmin(@Valid @RequestBody LoginAdminRequest request) {
        return service.loginAdmin(request);
    }
}
