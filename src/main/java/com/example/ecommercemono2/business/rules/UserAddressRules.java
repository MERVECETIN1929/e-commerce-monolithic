package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.UsersAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserAddressRules {
    private final UsersAddressRepository repository;

    public void existsUserIdAndAddressId(UUID userId, UUID addressId) {
        if (repository.existsUsersAddressByUserIdAndAddressId(userId, addressId)) {
            throw new BusinessException(Message.UsersAddress.NotExistId);

        }
    }

    public void existsNotUserIdAndAddressId(UUID userId, UUID addressId) {
        if (!repository.existsUsersAddressByUserIdAndAddressId(userId, addressId)) {
            throw new BusinessException(Message.UsersAddress.NotExistUsersAddressByUserIdAndAddressId);

        }
    }

    public void existsById(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Message.UsersAddress.NotExistId);
        }
    }
}
