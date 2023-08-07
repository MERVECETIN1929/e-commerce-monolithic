package com.example.ecommercemono2.repository;


import com.example.ecommercemono2.entities.Address;
import com.example.ecommercemono2.entities.UsersAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UsersAddressRepository extends JpaRepository<UsersAddress, UUID> {
    UsersAddress findUsersAddressByUserIdAndAddressId(UUID userId, UUID addressId);

    boolean existsUsersAddressByUserIdAndAddressId(UUID userId, UUID addressId);
    // todo change location

    @Query("SELECT a FROM UsersAddress users_address " +
            "INNER JOIN Address a on users_address.address.id=a.id  " +
            "WHERE users_address.user.id = :userId")
    List<Address> results(UUID userId);

    @Query("SELECT a FROM UsersAddress users_address " +
            "INNER JOIN Address a on users_address.address.id=a.id  " +
            "WHERE users_address.user.id = :userId and users_address.address.id=:addressId")
    Address getUsersAddressByUserId(UUID userId, UUID addressId);

}
