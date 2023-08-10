package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.address.AddressService;
import com.example.ecommercemono2.business.address.UpdateAddressRequest;
import com.example.ecommercemono2.business.address.UpdateAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/admin/address")
@AllArgsConstructor
public class AddressAdminController {
    private final AddressService addressService;
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        addressService.delete(id);
    }
    @PutMapping("/{id}")
    public UpdateAddressResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateAddressRequest request) {
        return addressService.update(id, request);
    }

}
