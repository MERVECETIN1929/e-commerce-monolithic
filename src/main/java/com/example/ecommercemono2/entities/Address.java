package com.example.ecommercemono2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String city;
    private String country;
    private int postCode;
    private String neighbourhood;
    private String street;
    private int flatsNumber;
    private int floorNumber;
    @OneToMany(mappedBy = "address")
    private List<UsersAddress> usersAddresses;
}
