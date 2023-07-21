package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderRules {
    private final OrderRepository repository;
    public void checkIfOrderExist(UUID orderId){
        if (!repository.existsById(orderId)) {
            throw new BusinessException(Message.Order.NotExistId);
        }
    }
}
