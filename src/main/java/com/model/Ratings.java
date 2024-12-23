package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id")
    private int ratingId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order; 

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant; 
    
   
    
    @Column(name = "rating_value", nullable = false)
    private int ratingValue;

    @Column(name="review")
    private String review; 

    public Ratings() {}

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "ratingId=" + ratingId +
                ", order=" + (order != null ? order.getOrderId() : "null") + // Displaying order ID for reference
                ", restaurant=" + (restaurant != null ? restaurant.getRestaurantId() : "null") + // Displaying restaurant ID for reference
                ", ratingValue=" + ratingValue +
                ", review='" + review + '\'' +
                '}';
    }
}
