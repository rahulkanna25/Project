<<<<<<< HEAD
<<<<<<<< HEAD:src/main/java/com/DAO/DeliveryDriverDAO.java
package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.DeliveryDrivers;

@Repository
public interface DeliveryDriverDAO extends JpaRepository<DeliveryDrivers,Integer> {

}
========
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
>>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc:src/main/java/com/DAO/OrdersCouponsDAO.java
=======
package com.DAO;

import com.model.DeliveryDrivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryDriverDAO extends JpaRepository<DeliveryDrivers, Integer> {
    List<DeliveryDrivers> findAll();
}
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
