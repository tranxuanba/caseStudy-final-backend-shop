package com.casestudy.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class BillDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "bills_id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;

    private int number;

    public BillDetail(Bill bill, Product product, int number) {
        this.bill = bill;
        this.product = product;
        this.number = number;
    }
}