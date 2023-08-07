package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.common.dto.payment.OrderPaymentRequest;

public interface PayService {
    boolean pay(OrderPaymentRequest request);

}
