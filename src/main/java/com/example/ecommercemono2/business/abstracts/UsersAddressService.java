package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.usersAddress.CreateUsersAddressRequest;

import java.util.UUID;

public interface UsersAddressService {
    void add(UUID userId,CreateUsersAddressRequest request);
}
