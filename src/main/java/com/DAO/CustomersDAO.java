package com.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.*;

import jakarta.persistence.criteria.Order;
@Repository
public interface CustomersDAO extends JpaRepository<Customers, Integer> {
	
	
}
