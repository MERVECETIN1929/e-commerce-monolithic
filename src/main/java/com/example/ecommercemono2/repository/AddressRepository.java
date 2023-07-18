package com.example.ecommercemono2.repository;

import com.example.ecommercemono2.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    boolean existsByCityAndCountryAndFlatsNumberAndStreetAndPostCodeAndNeighbourhoodAndFloorNumber
            (String city,String country,int flatsNumber,String street,int postCode,String neighbourhood,int floorNumber);
    Address findByCityAndCountryAndFlatsNumberAndStreetAndPostCodeAndNeighbourhoodAndFloorNumber
            (String city,String country,int flatsNumber,String street,int postCode,String neighbourhood,int floorNumber);

}
