package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.OrderItems;

@Repository
public interface OrderItemsDAO extends JpaRepository<OrderItems, Integer>{

}
