package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.userAddress.UsersAddressService;
import com.example.ecommercemono2.business.userAddress.CreateUsersAddressRequest;
import com.example.ecommercemono2.business.userAddress.UpdateUsersAddressRequest;
import com.example.ecommercemono2.business.userAddress.GetAllUserAddressesResponse;
import com.example.ecommercemono2.business.userAddress.GetUserAddressResponse;
import jakarta.validation.Valid;
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
    public void add(@RequestParam UUID userId,@Valid @RequestBody CreateUsersAddressRequest request) {
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
    public void updateUsersAddress(@PathVariable UUID usersAddressId,@Valid  @RequestBody UpdateUsersAddressRequest updateUsersAddressRequest) {
        service.updateUsersAddress(usersAddressId, updateUsersAddressRequest);
    }
}
