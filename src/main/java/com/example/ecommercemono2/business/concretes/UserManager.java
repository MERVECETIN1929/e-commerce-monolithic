package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.dto.request.admin.LoginAdminRequest;
import com.example.ecommercemono2.business.dto.response.admin.LoginAdminResponse;
import com.example.ecommercemono2.security.TokenService;
import com.example.ecommercemono2.entities.enums.Authority;
import com.example.ecommercemono2.business.abstracts.CartService;
import com.example.ecommercemono2.business.abstracts.UserService;
import com.example.ecommercemono2.business.dto.request.cart.CreateCartRequest;
import com.example.ecommercemono2.business.dto.request.user.CreateUserRequest;
import com.example.ecommercemono2.business.dto.request.user.LoginUserRequest;
import com.example.ecommercemono2.business.dto.request.user.UpdateUserRequest;
import com.example.ecommercemono2.business.dto.response.user.*;
import com.example.ecommercemono2.business.rules.UserRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.User;
import com.example.ecommercemono2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserManager implements UserService{
    private final ModelMapperService mapper;
    private final UserRepository repository;
    private final UserRules rules;
    private final CartService cartService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public CreateUserResponse add(CreateUserRequest request) {
        rules.checkIfExistUserByEmail(request.getEmail());
        var user = mapper.forRequest().map(request, User.class);
        user.setId(UUID.randomUUID());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAuthority(Authority.USER);
        String token=tokenService.generateToken(user);
        var saveUser = repository.save(user);
        cartService.add(new CreateCartRequest(saveUser.getId()));
        CreateUserResponse createUserResponse=mapper.forResponse().map(saveUser, CreateUserResponse.class);
        createUserResponse.setToken(token);
        return createUserResponse;
    }

    @Override
    public UpdateUserResponse update(UUID userId, UpdateUserRequest request) {
        User user = mapper.forRequest().map(request, User.class);
        rules.checkIfExistUserById(userId);
        user.setId(userId);
        repository.save(user);
        return mapper.forResponse().map(user, UpdateUserResponse.class);
    }

    @Override
    public GetUserResponse getById(UUID userId) {
        rules.checkIfExistUserById(userId);
        User user = repository.findById(userId).orElseThrow();
        return mapper.forResponse().map(user, GetUserResponse.class);
    }

    @Override
    public List<GetAllUsersResponse> getAll() {
        return repository.findAll().stream().map(user -> mapper.forResponse().map(user, GetAllUsersResponse.class)).toList();
    }

    @Override
    public void delete(UUID userId) {
        rules.checkIfExistUserById(userId);
        repository.deleteById(userId);
    }

    @Override
    public LoginUserResponse login(LoginUserRequest request) {
        checkAuth(request.getEmail(),request.getPassword());
        return new LoginUserResponse(generateToken(request.getEmail()));
    }

    @Override
    public LoginAdminResponse loginAdmin(LoginAdminRequest request) {
        checkAuth(request.getEmail(),request.getPassword());
        return new LoginAdminResponse(generateToken(request.getEmail()));
    }


    private void checkAuth(String email,String pasword){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,pasword));
    }
    private String generateToken(String email){
        User user=repository.findUserByEmail(email).orElseThrow();
        Map<String,Object> extraClaims=new HashMap<>();
        extraClaims.put("userId",user.getId());
        return tokenService.generateToken(extraClaims,user);
    }

}
