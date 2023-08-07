package com.example.ecommercemono2.business.concretes;

import com.example.ecommercemono2.business.abstracts.PayService;
import com.example.ecommercemono2.business.abstracts.PaymentService;
import com.example.ecommercemono2.business.dto.request.payment.CreatePaymentRequest;
import com.example.ecommercemono2.business.dto.request.payment.UpdatePaymentRequest;
import com.example.ecommercemono2.business.dto.response.payment.CreatePaymentResponse;
import com.example.ecommercemono2.business.dto.response.payment.GetAllPaymentsResponse;
import com.example.ecommercemono2.business.dto.response.payment.GetPaymentResponse;
import com.example.ecommercemono2.business.dto.response.payment.UpdatePaymentResponse;
import com.example.ecommercemono2.business.rules.PaymentRules;
import com.example.ecommercemono2.common.dto.payment.OrderPaymentRequest;
import com.example.ecommercemono2.common.dto.payment.TakeBackPaymentRequest;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Payment;
import com.example.ecommercemono2.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service(value="withCreditCard")
@AllArgsConstructor
public class PaymentManager implements PaymentService, PayService {
    private final ModelMapperService mapper;
    private final PaymentRepository repository;
    private final PaymentRules rules;
    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        rules.checkIfCardNumberExist(request.getCardNumber());
        Payment payment=mapper.forRequest().map(request,Payment.class);
        payment.setId(null);
        repository.save(payment);
        return mapper.forResponse().map(payment, CreatePaymentResponse.class);
    }

    @Override
    public UpdatePaymentResponse update(UUID id, UpdatePaymentRequest request) {
        rules.existsById(id);
        //rules.checkIfCardNumberExist();
        Payment payment=mapper.forRequest().map(request,Payment.class);
        payment.setId(id);
        repository.save(payment);
        return mapper.forResponse().map(payment,UpdatePaymentResponse.class);
    }

    @Override
    public GetPaymentResponse getById(UUID id) {
        rules.existsById(id);
        return mapper.forResponse().map(repository.findById(id).orElseThrow(),GetPaymentResponse.class);
    }

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        return repository.findAll().stream().map(payment->mapper.forResponse().map(payment,GetAllPaymentsResponse.class)).toList();
    }

    @Override
    public void delete(UUID id) {
        rules.existsById(id);
        repository.deleteById(id);
    }

    @Override
    public boolean pay(OrderPaymentRequest request) {
        rules.existsPaymentByCardNumberAndCardHolderNameAndCvvAndMonthAndYear(request);
        rules.isBalanceEnough(request);
        Payment payment=repository.findPaymentByCardNumber(request.getCardNumber());
        payment.setBalance(payment.getBalance()- request.getTotalPrice());
        repository.save(payment);
        return true;
    }

    @Override
    public void takeBackPayment(TakeBackPaymentRequest request) {
        rules.existsPaymentByCardNumberAndCardHolderNameAndCvvAndMonthAndYear(request);
        Payment payment=repository.findPaymentByCardNumber(request.getCardNumber());
        payment.setBalance(payment.getBalance()+request.getTakeBackPrice());
        repository.save(payment);
    }

}
