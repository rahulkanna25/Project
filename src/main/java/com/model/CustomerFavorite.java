package com.model;

import jakarta.persistence.*;

@Entity
public class CustomerFavorite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer favoriteId;

    @ManyToOne
    private Customers customer;

    @ManyToOne
    private Restaurants restaurant;

    public Integer getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(Integer favoriteId) {
        this.favoriteId = favoriteId;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }
}
