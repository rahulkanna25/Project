package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.DeliveryDriverDAO;
import com.DAO.OrdersDAO;
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
			throw new RuntimeException("No Drivers Available");
		}
		
		return Dl;
		
	}
	
	public DeliveryDrivers getDriver(int id) {
		
		Optional<DeliveryDrivers> driver =deliveryDriversDAO.findById(id);
		
		if(driver==null) {
			
			throw new RuntimeException("No Driver Exists");
		}		
		return driver.get();	
	}

	public void assignOrder(int orderId,int driverId) {
		
	   Optional<Orders> order = ordersDAO.findById(orderId);
	   Optional <DeliveryDrivers> deliveryDriver = deliveryDriversDAO.findById(driverId);
	   
	   if(deliveryDriver==null) {
		   
		   throw new RuntimeException("No Driver Exists");
	   }
	   if(order == null) {
		   
		   throw new RuntimeException("No Order Exists");
	   }
	   
	   Orders updatedOrder = order.get();
	   //DeliveryDrivers Driver = deliveryDriver.get();   
	   
	   ordersDAO.save(updatedOrder);    
	    
	}
	
	public List<Orders> allOrders(int driverId){
		
		Optional <DeliveryDrivers> deliveryDriver = deliveryDriversDAO.findById(driverId);
		
		if(deliveryDriver==null) {
			   
			   throw new RuntimeException("No Driver Exists");
		   }
		
		List<Orders> ol = deliveryDriver.get().getOrders();
		
		if(ol.isEmpty()){
			
			throw new RuntimeException("No Orders Assigned");
		}
		return ol;
	}
	
	public void updateLocation(int driverId, String driverLocation) {
		Optional <DeliveryDrivers> deliveryDriver = deliveryDriversDAO.findById(driverId);
		   if(deliveryDriver==null) {
			   
			   throw new RuntimeException("No Driver Exists");
		   }
		   DeliveryDrivers Driver = deliveryDriver.get();
		   Driver.setDriverLocation(driverLocation);
		   deliveryDriversDAO.save(Driver);	
	}
}
