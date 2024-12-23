package com.model;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
=======
import jakarta.persistence.*;
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc

@Entity
@Table(name = "ratings")
public class Ratings {

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
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
    @Column(name = "rating_id")
    private int ratingId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
<<<<<<< HEAD
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;
=======
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
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
}
