package com.casestudy.model.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private double weight;
    private String description;
    private String image;

    @ManyToOne
    private Category category;
}
