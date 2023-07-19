package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.business.dto.request.payment.CreatePaymentRequest;
import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentRules {
    private final PaymentRepository repository;
    public void checkIfCardNumberExist(String cardNumber){
        if (repository.existsByCardNumber(cardNumber)) {
            throw new BusinessException(Message.Payment.ExistByCardNumber);

        }
    }
    public void existsById(UUID id){
        if(!repository.existsById(id)){
            throw new BusinessException(Message.Payment.NotExistId);
        }
    }
}
