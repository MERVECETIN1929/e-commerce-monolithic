package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.admin.LoginAdminRequest;
import com.example.ecommercemono2.business.admin.LoginAdminResponse;
import com.example.ecommercemono2.business.user.GetAllUsersResponse;
import com.example.ecommercemono2.business.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/admin/user")
public class UserAdminController {
    private final UserService service;
    @GetMapping
    public List<GetAllUsersResponse> getAll() {
        return service.getAll();
    }


}
