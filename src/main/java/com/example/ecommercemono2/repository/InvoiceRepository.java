package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface InvoiceRepository extends MongoRepository<Invoice, UUID> {
    List<Invoice> findAllByUserId(UUID userId);
}
