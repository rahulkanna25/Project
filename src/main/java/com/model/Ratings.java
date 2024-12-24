package com.model;

<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
<<<<<<< HEAD
=======
import jakarta.persistence.*;
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======

import jakarta.persistence.*;

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

@Entity
@Table(name = "ratings")
public class Ratings {

<<<<<<< HEAD
<<<<<<< HEAD
    public Ratings(int ratingId, int rating, String review, Orders order, Restaurants restaurant) {
		super();
		
		this.ratingId = ratingId;
		this.rating = rating;
		this.review = review;
		this.order = order;
		this.restaurant = restaurant;
	}
    
    public Ratings() {}

	@Override
	public String toString() {
		return "Ratings [ratingId=" + ratingId + ", rating=" + rating + ", review=" + review + ", order=" + order
				+ ", restaurant=" + restaurant + "]";
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
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

	@Id
=======
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    @Column(name = "rating_id")
    private int ratingId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;
<<<<<<< HEAD
=======
    private Orders order; 
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

   

    
   
    
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
<<<<<<< HEAD
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
}
