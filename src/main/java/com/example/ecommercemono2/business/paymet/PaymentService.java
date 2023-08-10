package com.example.ecommercemono2.business.paymet;

import com.example.ecommercemono2.common.dto.payment.TakeBackPaymentRequest;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    CreatePaymentResponse add(CreatePaymentRequest request);
    UpdatePaymentResponse update(UUID id, UpdatePaymentRequest request);
    GetPaymentResponse getById(UUID id);
    List<GetAllPaymentsResponse> getAll();
    void delete(UUID id);
    void takeBackPayment(TakeBackPaymentRequest request);

}
