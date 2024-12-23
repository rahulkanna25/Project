package com.DAO;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.DeliveryAddress;
import com.model.Orders;
import com.model.Ratings;
@Repository
public interface OrdersDAO extends JpaRepository<Orders, Integer>{

	
	
	List<Orders> findByCustomer_CustomerId(int customerid);
 


	  
	    
	    List<Orders> findByDeliveryDriver_DriverId(int driverId);
	    
	    List<Orders> findByRestaurant_RestaurantId(int restaurantId);

	  }

