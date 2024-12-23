package com.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Ratings;

@Repository
public interface RatingsDAO extends JpaRepository<Ratings, Integer>{
	
	List<Ratings> findByRestaurant_restaurantId(int restaurantId);
	
	List<Ratings> findByOrder_Customer_CustomerId(int customerId); 
	
	
	@Query("SELECT r FROM Ratings r JOIN r.order o WHERE o.customer.customerId = :customerId")
	List<Ratings> findRatingsByCustomerId(@Param("customerId") int customerId);
	
}


