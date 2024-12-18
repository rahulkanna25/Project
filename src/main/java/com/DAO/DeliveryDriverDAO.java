package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.DeliveryDrivers;

@Repository
public interface DeliveryDriverDAO extends JpaRepository<DeliveryDrivers,Integer> {

}
