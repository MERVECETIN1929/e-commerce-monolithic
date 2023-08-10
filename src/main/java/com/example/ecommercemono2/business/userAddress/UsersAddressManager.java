package com.example.ecommercemono2.business.userAddress;

import com.example.ecommercemono2.business.address.AddressService;
import com.example.ecommercemono2.business.user.UserService;
import com.example.ecommercemono2.business.address.CreateAddressRequest;
import com.example.ecommercemono2.business.address.CreateAddressResponse;
import com.example.ecommercemono2.business.rules.AddressRules;
import com.example.ecommercemono2.business.rules.UserAddressRules;
import com.example.ecommercemono2.business.rules.UserRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Address;
import com.example.ecommercemono2.entities.User;
import com.example.ecommercemono2.entities.UsersAddress;
import com.example.ecommercemono2.repository.UsersAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UsersAddressManager implements UsersAddressService {
    private final AddressService addressService;
    private final AddressRules addressRules;
    private final UsersAddressRepository repository;
    private final UserRules userRules;
    private final ModelMapperService mapper;
    private final UserService userService;
    private final UserAddressRules rules;

    @Override
    public void add(UUID userId, CreateUsersAddressRequest request) {
        userRules.checkIfExistUserById(userId);
        CreateAddressRequest createAddressRequest = mapper.forRequest().map(request, CreateAddressRequest.class);
        CreateAddressResponse createAddressResponse;
        if (!addressService.existsTryCreateAddress(createAddressRequest)) {
            createAddressResponse = addressService.add(createAddressRequest);
        } else {
            createAddressResponse = addressService.findAddress(createAddressRequest);
        }
        rules.existsUserIdAndAddressId(userId, createAddressResponse.getId());
        UsersAddress usersAddress = new UsersAddress();
        usersAddress.setId(null);
        usersAddress.setUser(mapper.forRequest().map(userService.getById(userId), User.class));
        usersAddress.setAddress(mapper.forRequest().map(addressService.getById(createAddressResponse.getId()), Address.class));
        repository.save(usersAddress);
    }

    @Override
    public void delete(UUID usersAddressId) {
        rules.existsById(usersAddressId);
        repository.deleteById(usersAddressId);

    }


    @Override
    public GetUserAddressResponse getUsersAddressByUserId(UUID userId, UUID addressId) {
        userRules.checkIfExistUserById(userId);
        addressRules.existById(addressId);
        rules.existsNotUserIdAndAddressId(userId, addressId);
        GetUserAddressResponse getUserAddressResponse = mapper.forResponse().map(repository.getUsersAddressByUserId(userId, addressId), GetUserAddressResponse.class);
        getUserAddressResponse.setId(repository.findUsersAddressByUserIdAndAddressId(userId, addressId).getId());
        return getUserAddressResponse;
    }

    @Override
    public void updateUsersAddress(UUID usersAddressId, UpdateUsersAddressRequest updateUsersAddressRequest) {
        CreateAddressRequest createAddressRequest = mapper.forRequest().map(updateUsersAddressRequest, CreateAddressRequest.class);
        CreateAddressResponse createAddressResponse;
        if (addressService.existsTryCreateAddress(createAddressRequest)) {
            createAddressResponse = addressService.findAddress(createAddressRequest);
        } else {
            createAddressResponse = addressService.add(createAddressRequest);
        }
        User user = mapper.forRequest().map(userService.getById(updateUsersAddressRequest.getUserId()), User.class);
        Address address = mapper.forRequest().map(createAddressResponse.getId(), Address.class);
        UsersAddress usersAddress = new UsersAddress(usersAddressId, user, address);
        repository.save(usersAddress);
    }

    public List<GetAllUserAddressesResponse> getAllAddressByUserId(UUID userId) {
        userRules.checkIfExistUserById(userId);
        List<GetAllUserAddressesResponse> getAllUserAddressesResponses = repository.results(userId).stream().map(usersAddress -> mapper.forResponse().map(usersAddress
                , GetAllUserAddressesResponse.class)).toList();
        for (GetAllUserAddressesResponse getAllUserAddressesResponse : getAllUserAddressesResponses) {
            getAllUserAddressesResponse.setId(repository.findUsersAddressByUserIdAndAddressId(userId, getAllUserAddressesResponse.getAddressId()).getId());
        }
        return getAllUserAddressesResponses;
    }
}
