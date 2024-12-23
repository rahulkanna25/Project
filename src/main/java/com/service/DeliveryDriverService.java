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
	   DeliveryDrivers Driver = deliveryDriver.get();   
>>>>>>> d786bd89d9c99c8aff1c3b01f7bedce1b391f68f
	   if(!order.isPresent()) {
		   
		   throw new OrderNotFoundException("No Order Exists");
	   }
		   
	   
	   Orders updatedOrder = order.get();
	   
<<<<<<< HEAD
	  
=======
>>>>>>> d786bd89d9c99c8aff1c3b01f7bedce1b391f68f
	   updatedOrder.setDeliveryDriver(Driver);
	   ordersDAO.save(updatedOrder);    
	    
	}
	
	public List<Orders> allOrders(int driverId){
		
		Optional <DeliveryDrivers> deliveryDriver = deliveryDriversDAO.findById(driverId);
		
		if(!deliveryDriver.isPresent()) {
			   
			   throw new DriverNotFoundException("No Driver Exists");
		   }
		
		List<Orders> ol = ordersDAO.findByDeliveryDriverDriverid(driverId);
		
		if(ol.isEmpty()){
			
			throw new EmptyListException("No Orders Assigned");
		}
		return ol;
	}
	
	public void updateLocation(int driverId, String driverLocation) {
		Optional <DeliveryDrivers> deliveryDriver = deliveryDriversDAO.findById(driverId);
		   if(!deliveryDriver.isPresent()) {
			   
			   throw new DriverNotFoundException("No Driver Exists");
		   }
		   DeliveryDrivers Driver = deliveryDriver.get();
		   Driver.setDriverLocation(driverLocation);
		   deliveryDriversDAO.save(Driver);	
	}
}
