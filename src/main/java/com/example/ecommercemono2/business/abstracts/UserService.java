package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.user.CreateUserRequest;
import com.example.ecommercemono2.business.dto.request.user.UpdateUserRequest;
import com.example.ecommercemono2.business.dto.response.user.CreateUserResponse;
import com.example.ecommercemono2.business.dto.response.user.GetAllUsersResponse;
import com.example.ecommercemono2.business.dto.response.user.GetUserResponse;
import com.example.ecommercemono2.business.dto.response.user.UpdateUserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    CreateUserResponse add(CreateUserRequest request);
    UpdateUserResponse update(UUID userId, UpdateUserRequest request);
    GetUserResponse getById(UUID userId);
    List<GetAllUsersResponse> getAll();
    void delete(UUID userId);
}
