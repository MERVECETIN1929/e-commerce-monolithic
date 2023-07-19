package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.UsersAddressService;
import com.example.ecommercemono2.business.dto.request.usersAddress.CreateUsersAddressRequest;
import com.example.ecommercemono2.business.dto.request.usersAddress.UpdateUsersAddressRequest;
import com.example.ecommercemono2.business.dto.response.usersAddress.GetAllUserAddressesResponse;
import com.example.ecommercemono2.business.dto.response.usersAddress.GetUserAddressResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-address")
@AllArgsConstructor
public class UsersAddressController {
    private final UsersAddressService service;

    @PostMapping("/{userId}")
    public void add(@RequestParam UUID userId, @RequestBody CreateUsersAddressRequest request) {
        service.add(userId, request);
    }

    @GetMapping("/{userId}")
    List<GetAllUserAddressesResponse> getAll(@PathVariable UUID userId) {
        return service.getAllAddressByUserId(userId);
    }

    @GetMapping("/{userId}/{addressId}")
    GetUserAddressResponse getUsersAddressByUserId(@RequestParam UUID userId, @RequestParam UUID addressId) {
        return service.getUsersAddressByUserId(userId, addressId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }

    @PutMapping("/{usersAddressId}")
    public void updateUsersAddress(@PathVariable UUID usersAddressId, @RequestBody UpdateUsersAddressRequest updateUsersAddressRequest) {
        service.updateUsersAddress(usersAddressId, updateUsersAddressRequest);
    }
}
