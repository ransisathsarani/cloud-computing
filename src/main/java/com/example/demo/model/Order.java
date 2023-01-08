package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "food_id")
    private int food_id;

    @Column(name = "status")
    private String status = "Order Placed";

    @Column(name = "total")
    private double total = 0.00;


}
