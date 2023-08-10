package com.example.ecommercemono2.business.address;

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
