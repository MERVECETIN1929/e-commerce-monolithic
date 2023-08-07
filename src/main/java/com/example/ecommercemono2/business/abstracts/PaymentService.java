package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.payment.CreatePaymentRequest;
import com.example.ecommercemono2.business.dto.request.payment.UpdatePaymentRequest;
import com.example.ecommercemono2.business.dto.response.payment.CreatePaymentResponse;
import com.example.ecommercemono2.business.dto.response.payment.GetAllPaymentsResponse;
import com.example.ecommercemono2.business.dto.response.payment.GetPaymentResponse;
import com.example.ecommercemono2.business.dto.response.payment.UpdatePaymentResponse;
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
