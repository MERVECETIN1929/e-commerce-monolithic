package com.example.ecommercemono2.entities;

import com.example.ecommercemono2.entities.enums.Color;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private double unitPrice;
    private String information;
    @Enumerated(EnumType.STRING)
    private Color color;
    private String categoryName;
    private String brandName;
    private int quantity;
    private double totalPrice;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonBackReference
    private Order order;
    private UUID productId;
}
