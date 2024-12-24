package com.DAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.model.Ratings;

@Repository
public interface RatingsDAO extends JpaRepository<Ratings, Integer>{

<<<<<<< HEAD
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
	
	List<Ratings> findByRestaurant_restaurantId(int restaurantId);

	
<<<<<<< HEAD
	List<Ratings> findByOrder_Customer_CustomerId(int customerId); 
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
	
	
	@Query("SELECT r FROM Ratings r JOIN r.order o WHERE o.customer.customerId = :customerId")
	List<Ratings> findRatingsByCustomerId(@Param("customerId") int customerId);
<<<<<<< HEAD
	

=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

	
}

<<<<<<< HEAD
=======


	            


>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
