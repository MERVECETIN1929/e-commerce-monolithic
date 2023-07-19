package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
    boolean existsByName(String name);

    boolean existsBrandById(UUID brandId);
}
