package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    boolean existsByCardNumber(String cardNumber);
    boolean findPaymentByCardNumberAndCardHolderNameAndCvvAndMonthAndYear(
            String cardNumber,String cardHolderName,int cvv,int month,int year
    );
    Payment findPaymentByCardNumber(String cardNumber);
}
