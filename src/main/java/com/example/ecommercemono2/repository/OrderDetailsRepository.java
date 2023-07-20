package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, UUID> {
}
