package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CartItemRules {
    private final CartItemRepository repository;

    public void existCartItemById(UUID id) {
        if (!repository.existsCartItemById(id)) {
            throw new BusinessException(Message.CartItem.NotExistId);
        }
    }
    public void cardIsEmpty(UUID cardId){
        if(!repository.existsCartItemByCartId(cardId)){
            throw new BusinessException(Message.CartItem.CardIsEmpty);
        }
    }
}
