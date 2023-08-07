package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.PayService;
import com.example.ecommercemono2.common.dto.payment.OrderPaymentRequest;
import org.springframework.stereotype.Service;

@Service(value="payAtTheDoor")

public class AtTheDoorPayment implements PayService {

    @Override
    public boolean pay(OrderPaymentRequest request) {

        return false;
    }



}
