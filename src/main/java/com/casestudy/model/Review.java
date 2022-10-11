package com.casestudy.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int rating;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;
}

