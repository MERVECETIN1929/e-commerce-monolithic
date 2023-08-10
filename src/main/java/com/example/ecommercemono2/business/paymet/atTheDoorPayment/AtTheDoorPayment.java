package com.example.ecommercemono2.business.paymet.atTheDoorPayment;

import com.example.ecommercemono2.business.paymet.PayService;
import com.example.ecommercemono2.common.dto.payment.OrderPaymentRequest;
import org.springframework.stereotype.Service;

@Service(value="payAtTheDoor")

public class AtTheDoorPayment implements PayService {

    @Override
    public boolean pay(OrderPaymentRequest request) {

        return false;
    }



}
