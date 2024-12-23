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
 
}
=======

	  //List<Orders> findByDeliveryDriver_DriverId(int driverId);
	    List<Orders> findByCustomer_CustomerId(int customerId);
	    List<Orders> findByDeliveryDriver_DriverId(int driverId);
	    List<Ratings> findByRatings_RatingId(int ratingId);
	    List<Orders> findByRestaurant_RestaurantId(int restaurantId);

	  }
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
