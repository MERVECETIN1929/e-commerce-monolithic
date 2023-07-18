package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.AddressService;
import com.example.ecommercemono2.business.abstracts.UserService;
import com.example.ecommercemono2.business.abstracts.UsersAddressService;
import com.example.ecommercemono2.business.dto.request.address.CreateAddressRequest;
import com.example.ecommercemono2.business.dto.request.usersAddress.CreateUsersAddressRequest;
import com.example.ecommercemono2.business.dto.response.address.CreateAddressResponse;
import com.example.ecommercemono2.business.rules.UserRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Address;
import com.example.ecommercemono2.entities.User;
import com.example.ecommercemono2.entities.UsersAddress;
import com.example.ecommercemono2.repository.UsersAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
public class UsersAddressManager implements UsersAddressService {
    private final AddressService addressService;
    private final UsersAddressRepository repository;
    private final UserRules userRules;
    private final ModelMapperService mapper;
    private final UserService userService;
    @Override
    public void add(UUID userId, CreateUsersAddressRequest request) {
        userRules.checkIfExistUserById(userId);
        CreateAddressRequest createAddressRequest=mapper.forRequest().map(request,CreateAddressRequest.class);
        CreateAddressResponse createAddressResponse=new CreateAddressResponse();
        if(!addressService.existsTryCreateAddress(createAddressRequest)){
             createAddressResponse=addressService.add(createAddressRequest);
        }
        else{
           createAddressResponse= addressService.findAddress(createAddressRequest);
        }
        UsersAddress usersAddress=new UsersAddress();
        usersAddress.setId(null);
        usersAddress.setUser(mapper.forRequest().map(userService.getById(userId), User.class));
        usersAddress.setAddress(mapper.forRequest().map(addressService.getById(userId), Address.class));
        repository.save(usersAddress);
    }
}
