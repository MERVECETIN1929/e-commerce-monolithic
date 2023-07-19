package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.address.CreateAddressRequest;
import com.example.ecommercemono2.business.dto.request.address.UpdateAddressRequest;
import com.example.ecommercemono2.business.dto.response.address.CreateAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.GetAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.GetAllAddressResponse;
import com.example.ecommercemono2.business.dto.response.address.UpdateAddressResponse;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    CreateAddressResponse add(CreateAddressRequest request);

    List<GetAllAddressResponse> getAll();

    GetAddressResponse getById(UUID id);

    UpdateAddressResponse update(UUID id, UpdateAddressRequest request);

    void delete(UUID id);

    boolean existsTryCreateAddress(CreateAddressRequest request);

    CreateAddressResponse findAddress(CreateAddressRequest request);
}
