package com.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.*;
@Repository
public interface CustomersDAO extends JpaRepository<Customers, Integer> {
	List<Order> findByCustomerId(int customerId);
	List<Review> findByCustomerId(int customerId);
	
}
