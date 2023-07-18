package com.example.ecommercemono2.entities;

import com.example.ecommercemono2.entities.enums.Color;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private double unitPrice;
    private int stock;
    private String information;
    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Category category;
    @Enumerated(EnumType.STRING)
    private Color color;

}
