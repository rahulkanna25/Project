
//package com.DAO;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.model.OrdersCoupons;
//
//@Repository
////public interface OrdersCouponsDAO  extends JpaRepository<OrdersCoupons, Integer>{
//
//}

package com.DAO;

import com.model.DeliveryDrivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryDriverDAO extends JpaRepository<DeliveryDrivers, Integer> {
    List<DeliveryDrivers> findAll();
}

