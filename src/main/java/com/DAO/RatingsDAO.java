package com.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;

@Repository
public interface RatingsDAO extends JpaRepository<Ratings, Integer>{
<<<<<<< HEAD
	
	List<Ratings> findByRestaurant_restaurantId(int restaurantId);
	
	List<Ratings> findByOrder_Customer_CustomerId(int customerId); 
	
	
	@Query("SELECT r FROM Ratings r JOIN r.order o WHERE o.customer.customerId = :customerId")
	List<Ratings> findRatingsByCustomerId(@Param("customerId") int customerId);
	
}


=======
	@Query("SELECT r FROM Ratings r JOIN r.order o JOIN o.customer c WHERE c.customerId = :customerId")
	List<Ratings> findByOrderId(int order);                  
}
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
