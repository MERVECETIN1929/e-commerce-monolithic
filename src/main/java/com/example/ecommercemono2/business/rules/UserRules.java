package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserRules {
    private final UserRepository repository;
    public void checkIfExistUserById(UUID id){
        if(!repository.existsUserById(id)){
            throw new BusinessException(Message.User.NotExistId);
        }
    }
    public void checkIfExistUserByEmail(String email){
        if(repository.existsUserByEmail(email)){
            throw new BusinessException(Message.User.AlreadyExistEmail);
        }
    }
}
