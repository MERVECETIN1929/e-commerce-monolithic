package com.example.ecommercemono2.business.rules;

import com.example.ecommercemono2.common.constants.Message;
import com.example.ecommercemono2.common.exception.BusinessException;
import com.example.ecommercemono2.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class InvoiceRules {
    private final InvoiceRepository repository;
    public void checkIfInvoiceExists(UUID id){
        if(!repository.existsById(id)){
            throw new BusinessException(Message.Invoice.NotExistId);

        }
    }
}
