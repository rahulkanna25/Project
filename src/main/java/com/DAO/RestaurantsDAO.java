package com.DAO;

import com.model.Restaurants;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsDAO extends JpaRepository<Restaurants, Integer> {
	
}
