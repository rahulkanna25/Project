package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ratings")
public class Ratings {

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
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review", columnDefinition = "TEXT")
    private String review;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;
}
