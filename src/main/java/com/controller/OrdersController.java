
package com.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Orders;
import com.service.OrdersService;



@RestController
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    
    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody Orders order) {
        
            ordersService.addOrder(order);
            return ResponseEntity.ok("Order placed successfully");
        
            
        
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable int orderId) {
    	Orders order = ordersService.getOrderDetails(orderId);
        
        return new ResponseEntity<Orders>(order,HttpStatus.OK);
    }

    
    @PutMapping("/{orderId}/{status}")
    public ResponseEntity<?> updateOrderStatus(@PathVariable int orderId,@PathVariable String status ) {
    	
    	ordersService.updateOrderStatus(orderId, status);
    	
    	return new ResponseEntity<String>("Order Updated sucessfully",HttpStatus.OK);
    	
        
    }

    
    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> cancelOrder(@PathVariable int orderId) {
    	ordersService.cancelOrder(orderId);
    	
    	return new ResponseEntity<String>("Order deleted sucessfully",HttpStatus.OK);
    	
        
    }

}
