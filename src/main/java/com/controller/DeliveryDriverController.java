package com.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.DeliveryDrivers;

import com.model.Orders;
import com.service.DeliveryDriverService;


@RestController
@RequestMapping("/api")
public class DeliveryDriverController {
	
	@Autowired
	DeliveryDriverService deliveryDriverService;
	
	
	@GetMapping("/drivers")
	public ResponseEntity<?> getDrivers(){
		
		List<DeliveryDrivers> driverList =deliveryDriverService.getAll();	
		
		return new ResponseEntity<List<DeliveryDrivers>>(driverList,HttpStatus.OK);
		
	}
	@GetMapping("/drivers/{id}")
	public ResponseEntity<?>  getDriver(@PathVariable int driverId) {
		DeliveryDrivers driver = deliveryDriverService.getDriver(driverId);
		
		return new ResponseEntity<DeliveryDrivers>(driver,HttpStatus.OK);
	}
	
	@PutMapping("api/orders/{orderid}/assignorder/{driverid}")
	public ResponseEntity<?>  assignOrders(@PathVariable int driverid,@PathVariable int orderid) {
		
		  deliveryDriverService.assignOrder(orderid, driverid);
		
		return new ResponseEntity<String>("Order Assigned",HttpStatus.OK);
	}
	
	
	@PutMapping("/api/drivers/{driverid}/{location}")
	public ResponseEntity<?>  updateLocation(@PathVariable int driverid,@PathVariable String location) {
		
		  deliveryDriverService.updateLocation(driverid, location);
		
		return new ResponseEntity<String>("Location Updated",HttpStatus.OK);
	}
	
	@GetMapping("/api/drivers/{driverid}/orders")
    public ResponseEntity<?>  getOrders(@PathVariable int driverid) {
		
		List<Orders> orderList = deliveryDriverService.allOrders(driverid);
		
		return new ResponseEntity<List<Orders>>(orderList,HttpStatus.OK);
	}
	
	

}
