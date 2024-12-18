package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.OrdersCoupons;

@Repository
public interface OrdersCouponsDAO  extends JpaRepository<OrdersCoupons, Integer>{

}
