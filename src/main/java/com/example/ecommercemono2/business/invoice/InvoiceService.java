package com.example.ecommercemono2.business.invoice;

import java.util.List;
import java.util.UUID;

public interface InvoiceService {
    void add(CreateInvoiceRequest request);
    List<GetAllInvoiceResponse> getAll();
    List<GetAllInvoiceResponse> getAllInvoiceByUserId(UUID userId);
    GetInvoiceResponse getById(UUID id);
    void delete(UUID id);
}
