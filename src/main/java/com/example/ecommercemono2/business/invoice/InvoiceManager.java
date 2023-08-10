package com.example.ecommercemono2.business.invoice;

import com.example.ecommercemono2.business.rules.InvoiceRules;
import com.example.ecommercemono2.business.rules.UserRules;
import com.example.ecommercemono2.common.mapper.ModelMapperService;
import com.example.ecommercemono2.entities.Invoice;
import com.example.ecommercemono2.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private final ModelMapperService mapper;
    private final InvoiceRepository repository;
    private final UserRules userRules;
    private final InvoiceRules rules;
    @Override
    public void add(CreateInvoiceRequest request) {
        Invoice invoice=mapper.forRequest().map(request, Invoice.class);
        invoice.setId(UUID.randomUUID());
        repository.save(invoice);
    }

    @Override
    public List<GetAllInvoiceResponse> getAll() {
        return repository.findAll().stream()
                .map(invoice -> mapper.forResponse().map(invoice,GetAllInvoiceResponse.class)).toList();
    }

    @Override
    public List<GetAllInvoiceResponse> getAllInvoiceByUserId(UUID userId) {
        userRules.checkIfExistUserById(userId);
        return repository.findAllByUserId(userId).stream()
                .map(invoice -> mapper.forRequest().map(invoice,GetAllInvoiceResponse.class)).collect(Collectors.toList());
    }

    @Override
    public GetInvoiceResponse getById(UUID id) {
        rules.checkIfInvoiceExists(id);
        return mapper.forResponse().map(repository.findById(id).orElseThrow(),GetInvoiceResponse.class);
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfInvoiceExists(id);
        repository.deleteById(id);
    }
}
