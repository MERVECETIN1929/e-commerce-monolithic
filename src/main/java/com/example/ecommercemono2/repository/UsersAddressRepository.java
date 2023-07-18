package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.UsersAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersAddressRepository extends JpaRepository<UsersAddress, UUID> {
}
