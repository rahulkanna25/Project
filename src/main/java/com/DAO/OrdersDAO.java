package com.DAO;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Orders;
@Repository
public interface OrdersDAO extends JpaRepository<Orders, Integer>{
 
}