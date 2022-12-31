package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "foods")
@Data
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

}
