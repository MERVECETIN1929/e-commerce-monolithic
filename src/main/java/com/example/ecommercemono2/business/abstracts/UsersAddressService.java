package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.usersAddress.CreateUsersAddressRequest;
import com.example.ecommercemono2.business.dto.request.usersAddress.UpdateUsersAddressRequest;
import com.example.ecommercemono2.business.dto.response.usersAddress.GetAllUserAddressesResponse;
import com.example.ecommercemono2.business.dto.response.usersAddress.GetUserAddressResponse;

import java.util.List;
import java.util.UUID;

public interface UsersAddressService {
    void add(UUID userId, CreateUsersAddressRequest request);

    void delete(UUID usersAddressId);

    List<GetAllUserAddressesResponse> getAllAddressByUserId(UUID userId);

    GetUserAddressResponse getUsersAddressByUserId(UUID userId, UUID addressId);

    void updateUsersAddress(UUID usersAddressId, UpdateUsersAddressRequest updateUsersAddressRequest);

}
