package com.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "menuitems")
public class MenuItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_description")
    private String description;

    @Column(name = "item_price", nullable = false)
    private float price;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;

    @OneToMany(mappedBy = "menuItems", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;

    // Default constructor
    public MenuItems() {}

    // Constructor with all fields
    public MenuItems(int id, String itemName, String description, float price, Restaurants restaurant, List<OrderItems> orderItems) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.price = price;
        this.restaurant = restaurant;
        this.orderItems = orderItems;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

}
