package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.user.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/registered-user")
public class RegisteredUserController {
    private final UserService service;


    @PutMapping("/{id}")
    public UpdateUserResponse update(@PathVariable UUID id,@Valid  @RequestBody UpdateUserRequest request) {
        return service.update(id, request);
    }
    @GetMapping("/{id}")
    public GetUserResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }


}
