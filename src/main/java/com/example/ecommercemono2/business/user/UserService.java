package com.example.ecommercemono2.business.user;

import com.example.ecommercemono2.business.admin.CreateAdminRequest;
import com.example.ecommercemono2.business.admin.CreateAdminResponse;
import com.example.ecommercemono2.business.admin.LoginAdminRequest;
import com.example.ecommercemono2.business.admin.LoginAdminResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    CreateUserResponse add(CreateUserRequest request);

    UpdateUserResponse update(UUID userId, UpdateUserRequest request);

    GetUserResponse getById(UUID userId);

    List<GetAllUsersResponse> getAll();

    void delete(UUID userId);
    LoginUserResponse login(LoginUserRequest request);
    LoginAdminResponse loginAdmin(LoginAdminRequest request);
    CreateAdminResponse addAdmin(CreateAdminRequest request);
}
