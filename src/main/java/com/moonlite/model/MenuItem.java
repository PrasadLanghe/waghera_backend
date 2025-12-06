package com.moonlite.model; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity 
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String category; // e.g., "Breakfast", "Lunch", "Vegetarian"

    private String imageUrl;
    
    // Default Constructor (required by JPA)
    public MenuItem() {}

    // *** CORRECT CONSTRUCTOR FOR DATALOADER ***
    // This constructor ensures the values are assigned to the fields, preventing the Null error.
    public MenuItem(String name, String description, double price, String category, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category; 
        this.imageUrl = imageUrl;
    }

    

	public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}