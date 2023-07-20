package com.example.ecommercemono2.business.rules;


import com.example.ecommercemono2.common.constants.Message;

import com.example.ecommercemono2.common.dto.PaymentRequest;
import com.example.ecommercemono2.common.dto.payment.OrderPaymentRequest;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.entities.Payment;
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
    public void isBalanceEnough(OrderPaymentRequest request){
        Payment payment=repository.findPaymentByCardNumber(request.getCardNumber());
        if(request.getTotalPrice()>payment.getBalance()){
            throw new BusinessException(Message.Payment.BalanceNotEnough);
        }
    }
    public void existsPaymentByCardNumberAndCardHolderNameAndCvvAndMonthAndYear(PaymentRequest request){
        if(!repository.existsPaymentByCardNumberAndCardHolderNameAndCvvAndMonthAndYear(request.getCardNumber(),
           request.getCardHolderName(), request.getCvv(), request.getMonth(), request.getYear())){
            throw new BusinessException(Message.Payment.PaymentNotExists);
        }
    }
}
