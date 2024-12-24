
package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======


>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Orders;
import com.service.OrdersService;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

=======

import java.util.Optional;
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

@RestController
@RequestMapping("/api")
public class OrdersController {

    @Autowired
    private OrdersService ordersService; 


    
    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody Orders order) {
        
            ordersService.addOrder(order);
            return  new ResponseEntity<String>("Order Placed Sucessfully",HttpStatus.CREATED);
        
            
        
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

<<<<<<< HEAD
    @PostMapping
    public ResponseEntity<Orders> placeOrder(@RequestBody Orders order) {
        Orders newOrder = ordersService.placeOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable int orderId) {
        Optional<Orders> order = ordersService.getOrderById(orderId);
        if (order.isPresent()) {
            return ResponseEntity.ok(order.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Order not found\"}");
        }
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Object> updateOrderStatus(@PathVariable int orderId, @RequestBody String newStatus) {
        try {
            Orders updatedOrder = ordersService.updateOrderStatus(orderId, newStatus);
            return ResponseEntity.ok(updatedOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Order not found\"}");
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> cancelOrder(@PathVariable int orderId) {
        try {
            ordersService.cancelOrder(orderId);
            return ResponseEntity.ok("{\"code\": \"CANCELSUCCESS\", \"message\": \"Order canceled successfully\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"DELETEFAIL\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }
}
=======

}
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
