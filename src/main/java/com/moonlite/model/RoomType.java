package com.moonlite.model;


import jakarta.persistence.*;

@Entity
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeName;    // Single, Deluxe, Double
    private double price;       // Base price per night

    public RoomType() {}

    public RoomType(String typeName, double price) {
        this.typeName = typeName;
        this.price = price;
    }

    // getters & setters
    public Long getId() { return id; }
    public String getTypeName() { return typeName; }
    public void setTypeName(String typeName) { this.typeName = typeName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}

