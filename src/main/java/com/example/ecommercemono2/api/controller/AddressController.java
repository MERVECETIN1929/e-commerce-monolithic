package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.address.AddressService;
import com.example.ecommercemono2.business.address.CreateAddressRequest;
import com.example.ecommercemono2.business.address.UpdateAddressRequest;
import com.example.ecommercemono2.business.address.CreateAddressResponse;
import com.example.ecommercemono2.business.address.GetAddressResponse;
import com.example.ecommercemono2.business.address.GetAllAddressResponse;
import com.example.ecommercemono2.business.address.UpdateAddressResponse;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService service;


    @PostMapping
    public CreateAddressResponse add(@Valid  @RequestBody CreateAddressRequest request) {
        return service.add(request);
    }


    @GetMapping("/{id}")
    public GetAddressResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllAddressResponse> getAll() {
        return service.getAll();
    }


}
