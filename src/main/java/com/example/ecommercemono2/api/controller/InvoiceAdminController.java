package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.invoice.GetAllInvoiceResponse;
import com.example.ecommercemono2.business.invoice.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/invoice")
@AllArgsConstructor
public class InvoiceAdminController {
    private final InvoiceService service;
    @GetMapping
    public List<GetAllInvoiceResponse> getAll(){
        return service.getAll();
    }
}
