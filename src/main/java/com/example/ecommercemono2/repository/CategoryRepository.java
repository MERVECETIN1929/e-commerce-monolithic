package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    boolean existsByName(String name);

    boolean existsCategoryById(UUID categoryId);
}
