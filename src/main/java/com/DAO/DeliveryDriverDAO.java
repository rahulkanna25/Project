
package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.model.DeliveryDrivers;

import java.util.List;

@Repository
public interface DeliveryDriverDAO extends JpaRepository<DeliveryDrivers, Integer> {
    List<DeliveryDrivers> findAll();
}

