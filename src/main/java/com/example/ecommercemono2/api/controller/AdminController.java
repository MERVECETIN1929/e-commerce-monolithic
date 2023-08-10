package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.admin.CreateAdminRequest;
import com.example.ecommercemono2.business.admin.CreateAdminResponse;
import com.example.ecommercemono2.business.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@AllArgsConstructor
public class AdminController {
    private UserService service;
    @PostMapping
    public CreateAdminResponse add(@RequestBody CreateAdminRequest request){
        return service.addAdmin(request);
    }
}
