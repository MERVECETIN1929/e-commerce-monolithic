package com.example.ecommercemono2.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<OrderDetails> orderDetails;
    private String city;
    private String country;
    private int postCode;
    private String neighbourhood;
    private String street;
    private int flatsNumber;
    private int floorNumber;
    private LocalDate orderDate;
    private LocalDate arrivalDate;
    private double totalPrice;
    private boolean isPreparation;
    private boolean isItPaid;


}
