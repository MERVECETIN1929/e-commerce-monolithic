package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.abstracts.UserService;
import com.example.ecommercemono2.business.dto.request.user.CreateUserRequest;
import com.example.ecommercemono2.business.dto.request.user.UpdateUserRequest;
import com.example.ecommercemono2.business.dto.response.user.CreateUserResponse;
import com.example.ecommercemono2.business.dto.response.user.GetAllUsersResponse;
import com.example.ecommercemono2.business.dto.response.user.GetUserResponse;
import com.example.ecommercemono2.business.dto.response.user.UpdateUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;
    @PostMapping
    public CreateUserResponse add(@RequestBody CreateUserRequest request){
        return service.add(request);
    }
    @PutMapping("/{id}")
    public UpdateUserResponse update(@PathVariable UUID id,@RequestBody UpdateUserRequest request){
        return service.update(id,request);
    }
    @GetMapping("/{id}")
    public GetUserResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }
    @GetMapping
    public List<GetAllUsersResponse> getAll(){
        return service.getAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
