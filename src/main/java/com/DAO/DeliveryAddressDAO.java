package com.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.DeliveryAddress;

@Repository
public interface DeliveryAddressDAO extends JpaRepository<DeliveryAddress,Integer>{
	
	@Query("SELECT d FROM DeliveryAddress d JOIN d.customer c JOIN c.orders o WHERE o.restaurant.restaurantId = :restaurantId")
	List<DeliveryAddress> findAddressByRestaurantId(@Param("restaurantId")int restaurantId);

	
	
	
}
