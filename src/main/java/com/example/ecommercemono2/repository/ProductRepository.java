package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID>
{
    boolean existsProductById(UUID id);
}
