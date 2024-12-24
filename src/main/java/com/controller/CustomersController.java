package com.controller;
import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;
import com.model.Restaurants;
import com.service.CustomersService;
<<<<<<< HEAD


=======
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
<<<<<<< HEAD
    private CustomersService customersService;
    
    

=======
    private CustomersService customersService; 
    
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {
        List<Customers> customers = customersService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getCustomerById(@PathVariable int customerId) {
        Customers customer = customersService.getCustomerById(customerId);
        
            return ResponseEntity.ok(customer);

    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> updateCustomer(@PathVariable int customerId,
                                                  @RequestBody Customers updatedCustomer) {
        try {
            Customers updated = customersService.updateCustomer(customerId, updatedCustomer);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Customer not found");
        }
    }
    
   
    
    


    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int customerId) {
        
            customersService.deleteCustomer(customerId);
            return ResponseEntity.ok("Customer deleted successfully\"}");
        
    }


    @GetMapping("/{customerId}/orders")
    public ResponseEntity<?> getOrdersByCustomerId(@PathVariable int customerId) {
    	 
             List<Orders> ol = customersService.getOrdersByCustomerId(customerId);
             return new ResponseEntity<List<Orders>>(ol,HttpStatus.OK);
         
    
    }

    @GetMapping("/{customerId}/reviews")
    public ResponseEntity<List<Ratings>> getReviewsByCustomer(@PathVariable int customerId) {
        List<Ratings> reviews = customersService.getReviewsByCustomer(customerId);
        return ResponseEntity.ok(reviews);
    }
    
 
    
    @DeleteMapping("/{customerId}/favorites/{restaurantId}")
    public ResponseEntity<String> removeFavoriteRestaurant(
            @PathVariable int customerId,
            @PathVariable int restaurantId) {
    	
    	String response = customersService.removeFavoriteRestaurant(customerId, restaurantId);
        return ResponseEntity.ok(response);
    }
    
    
    @PostMapping("/{customerId}/favorites")
    public ResponseEntity<?> addFavoriteRestaurant( @PathVariable int customerId, @RequestBody Restaurants restaurant) {

         customersService.addFavoriteRestaurant(customerId, restaurant);
        return ResponseEntity.ok("Restaurant added");
    }

    }
    
  

