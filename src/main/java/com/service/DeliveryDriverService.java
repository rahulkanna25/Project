package com.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.DeliveryDriverDAO;
import com.DAO.OrdersDAO;
import com.exception.DriverNotFoundException;
import com.exception.EmptyListException;
import com.exception.OrderNotFoundException;
import com.model.DeliveryDrivers;
import com.model.Orders;



@Service
public class DeliveryDriverService {
	
	@Autowired
	DeliveryDriverDAO deliveryDriversDAO;
	
	@Autowired
	OrdersDAO  ordersDAO;
<<<<<<< HEAD

=======
	
	
	
	
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
	
	public List<DeliveryDrivers> getAll(){
		
		List <DeliveryDrivers> Dl = deliveryDriversDAO.findAll();
		if(Dl.isEmpty()) {
			throw new EmptyListException("No Drivers Available");
		}
		
		return Dl;
		
	}
	
	public DeliveryDrivers getDriver(int id) {
		
		Optional<DeliveryDrivers> driver =deliveryDriversDAO.findById(id);
		
		if(!driver.isPresent()) {
			
			throw new DriverNotFoundException("No Driver Exists");
		}		
		return driver.get();	
	}

	public void assignOrder(int orderId,int driverId) {
		
	   Optional<Orders> order = ordersDAO.findById(orderId);
	   Optional <DeliveryDrivers> deliveryDriver = deliveryDriversDAO.findById(driverId);
	   
	   if(!deliveryDriver.isPresent()) {
		   
		   throw new DriverNotFoundException("No Driver Exists");
	   }
<<<<<<< HEAD

		   DeliveryDrivers Driver = deliveryDriver.get();   
	   

	    

=======
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
	   if(!order.isPresent()) {
		   
		   throw new OrderNotFoundException("No Order Exists");
	   }
<<<<<<< HEAD
		   
	   
	   Orders updatedOrder = order.get();
	   

	  

=======
	   
	   Orders updatedOrder = order.get();
	   DeliveryDrivers Driver = deliveryDriver.get();   
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
	   updatedOrder.setDeliveryDriver(Driver);
	   ordersDAO.save(updatedOrder);    
	    
	}
	
	public List<Orders> allOrders(int driverId){
		
		Optional <DeliveryDrivers> deliveryDriver = deliveryDriversDAO.findById(driverId);
		
		if(!deliveryDriver.isPresent()) {
			   
			   throw new DriverNotFoundException("No Driver Exists");
		   }
		
<<<<<<< HEAD
		List<Orders> ol = ordersDAO.findByDeliveryDriverDriverid(driverId);
=======
		List<Orders> ol = ordersDAO.findByDeliveryDriver_DriverId(driverId);
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
		
		if(ol.isEmpty()){
			
			throw new EmptyListException("No Orders Assigned");
		}
		return ol;
	}
	
	public void updateLocation(int driverId, String driverLocation) {
		Optional <DeliveryDrivers> deliveryDriver = deliveryDriversDAO.findById(driverId);
<<<<<<< HEAD
		   if(!deliveryDriver.isPresent()) {
			   
			   throw new DriverNotFoundException("No Driver Exists");
=======
		   if(deliveryDriver.isEmpty()) {
			   
			   throw new EmptyListException("No Driver Exists");
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
		   }
		   DeliveryDrivers Driver = deliveryDriver.get();
		   Driver.setDriverLocation(driverLocation);
		   deliveryDriversDAO.save(Driver);	
	}
}
