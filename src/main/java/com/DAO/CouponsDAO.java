package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Coupons;

@Repository
public interface CouponsDAO extends JpaRepository<Coupons, Integer>{

}
