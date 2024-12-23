package com.model;

public class RatingDTO {
    private int ratingId;
    private int ratingValue;
    private String review;

    // Constructor, Getters, and Setters...
    public RatingDTO() {}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
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
    
    
    
}
