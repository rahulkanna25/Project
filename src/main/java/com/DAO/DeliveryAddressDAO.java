package com.DAO;
<<<<<<< HEAD


import java.util.List;

import java.util.List;

=======

import java.util.List;

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.DeliveryAddress;
<<<<<<< HEAD
 
import com.model.DeliveryAddress;
 
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

@Repository
public interface DeliveryAddressDAO extends JpaRepository<DeliveryAddress,Integer>{
	
	@Query("SELECT d FROM DeliveryAddress d JOIN d.customer c JOIN c.orders o WHERE o.restaurant.restaurantId = :restaurantId")
	List<DeliveryAddress> findAddressByRestaurantId(@Param("restaurantId")int restaurantId);
<<<<<<< HEAD
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

	
	
	
}
<<<<<<< HEAD

=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
