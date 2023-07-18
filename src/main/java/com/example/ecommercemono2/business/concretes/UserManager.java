package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.CartService;
import com.example.ecommercemono2.business.abstracts.UserService;
import com.example.ecommercemono2.business.dto.request.cart.CreateCartRequest;
import com.example.ecommercemono2.business.dto.request.user.CreateUserRequest;
import com.example.ecommercemono2.business.dto.request.user.UpdateUserRequest;
import com.example.ecommercemono2.business.dto.response.user.CreateUserResponse;
import com.example.ecommercemono2.business.dto.response.user.GetAllUsersResponse;
import com.example.ecommercemono2.business.dto.response.user.GetUserResponse;
import com.example.ecommercemono2.business.dto.response.user.UpdateUserResponse;
import com.example.ecommercemono2.business.rules.UserRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.User;
import com.example.ecommercemono2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserManager implements UserService {
    private final ModelMapperService mapper;
    private final UserRepository repository;
    private final UserRules rules;
    private final CartService cartService;

    @Override
    public CreateUserResponse add(CreateUserRequest request) {
        rules.checkIfExistUserByEmail(request.getEmail());
        var user=mapper.forRequest().map(request, User.class);
        user.setId(UUID.randomUUID());
        var saveUser=repository.save(user);
        cartService.add(new CreateCartRequest(saveUser.getId()));
        return mapper.forResponse().map(saveUser,CreateUserResponse.class);
    }

    @Override
    public UpdateUserResponse update(UUID userId, UpdateUserRequest request) {
        User user=mapper.forRequest().map(request,User.class);
        rules.checkIfExistUserById(userId);
        user.setId(userId);
        repository.save(user);
        return mapper.forResponse().map(user, UpdateUserResponse.class);
    }

    @Override
    public GetUserResponse getById(UUID userId) {
        rules.checkIfExistUserById(userId);
        var user=repository.findById(userId);
        return mapper.forResponse().map(user,GetUserResponse.class);
    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        return repository.findAll().stream().map(user->mapper.forResponse().map(user, GetAllUsersResponse.class)).toList();
    }

    @Override
    public void delete(UUID userId) {
        rules.checkIfExistUserById(userId);
        repository.deleteById(userId);
    }
}
