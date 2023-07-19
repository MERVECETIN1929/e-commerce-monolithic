package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.AddressService;
import com.example.ecommercemono2.business.dto.request.address.CreateAddressRequest;
import com.example.ecommercemono2.business.dto.request.address.UpdateAddressRequest;
import com.example.ecommercemono2.business.dto.response.address.CreateAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.GetAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.GetAllAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.UpdateAddressResponse;
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
    public CreateAddressResponse add(@RequestBody CreateAddressRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateAddressResponse update(@PathVariable UUID id, @RequestBody UpdateAddressRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public GetAddressResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @GetMapping
    public List<GetAllAddressResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
