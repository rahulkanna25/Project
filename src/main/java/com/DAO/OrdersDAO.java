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
<<<<<<< HEAD

	List<Orders> findByDeliveryDriverDriverid(int driverid);
	
	List<Orders> findByCustomerCustomerId(int customerid);
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

	
	
	List<Orders> findByCustomer_CustomerId(int customerid);
 


	  
	    
	    List<Orders> findByDeliveryDriver_DriverId(int driverId);
	    
	    List<Orders> findByRestaurant_RestaurantId(int restaurantId);

	  }

