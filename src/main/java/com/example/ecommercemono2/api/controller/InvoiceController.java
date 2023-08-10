package com.example.ecommercemono2.api.controller;

import com.example.ecommercemono2.business.invoice.InvoiceService;
import com.example.ecommercemono2.business.invoice.CreateInvoiceRequest;
import com.example.ecommercemono2.business.invoice.GetAllInvoiceResponse;
import com.example.ecommercemono2.business.invoice.GetInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/invoice")
@AllArgsConstructor
public class InvoiceController {
    private final InvoiceService service;
    @GetMapping("/{id}")
    @PostAuthorize("returnObject.email.equals(authentication.principal.email)")
    public GetInvoiceResponse getById(@PathVariable  UUID id){
        return service.getById(id);
    }

    @PostMapping
    public void add(@RequestBody CreateInvoiceRequest request){
        service.add(request);
    }

    @GetMapping("/getByUserId")
    @PreAuthorize("#userId.equals(authentication.principal.id)")
    public List<GetAllInvoiceResponse> getAllByUserId(@RequestParam UUID userId){
        return service.getAllInvoiceByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }





}
