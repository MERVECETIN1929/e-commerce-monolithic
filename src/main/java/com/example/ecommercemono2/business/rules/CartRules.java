package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CartRules {
    private final CartRepository repository;
    public void existById(UUID cartId){
        if(!repository.existsCartById(cartId)){
            throw new BusinessException(Message.Cart.NotExistId);
        }
    }
}
