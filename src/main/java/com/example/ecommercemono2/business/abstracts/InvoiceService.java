package com.example.ecommercemono2.business.abstracts;

import com.example.ecommercemono2.business.dto.request.invoice.CreateInvoiceRequest;
import com.example.ecommercemono2.business.dto.response.invoice.GetAllInvoiceResponse;
import com.example.ecommercemono2.business.dto.response.invoice.GetInvoiceResponse;

import java.util.List;
import java.util.UUID;

public interface InvoiceService {
    void add(CreateInvoiceRequest request);
    List<GetAllInvoiceResponse> getAll();
    List<GetAllInvoiceResponse> getAllInvoiceByUserId(UUID userId);
    GetInvoiceResponse getById(UUID id);
    void delete(UUID id);
}
