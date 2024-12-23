package com.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;
import com.service.CustomersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;
    
    
    @GetMapping
    public List<Customers> getAllCustomers() {
        return customersService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customers> getCustomerById(@PathVariable int customerId) {
        Optional<Customers> customer = customersService.getCustomerById(customerId);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable int customerId, @RequestBody Customers customerDetails) {
        try {
            Customers updatedCustomer = customersService.updateCustomer(customerId, customerDetails);
            return ResponseEntity.ok(updatedCustomer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    @GetMapping("/{customerId}/orders")
    public ResponseEntity<?> getOrdersByCustomerId(@PathVariable int customerId) {
    	 try {
             List<Orders> ol = customersService.getOrdersByCustomerId(customerId);
             return new ResponseEntity<List<Orders>>(ol,HttpStatus.OK);
         } catch (RuntimeException e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No reviews found");
         }
        
    }
    
    @GetMapping("/{customerId}/reviews")
    public ResponseEntity<?> getRatingsByCustomerId(@PathVariable int customerId) {
    	 try {
             List<Ratings> rl = customersService.getReviewsByCustomer(customerId);
             return new ResponseEntity<List<Ratings>>(rl,HttpStatus.OK);
         } catch (RuntimeException e) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
         }
        
    }
    
    


    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable int customerId) {
        try {
            customersService.deleteCustomer(customerId);
            return ResponseEntity.ok("Customer deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }

   
}
