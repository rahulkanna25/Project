package com.controller;

import com.exception.CustomerNotFoundException;
import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;
import com.model.Restaurants;
import com.service.CustomersService;
import com.service.RatingsService;

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
    private CustomersService customersService; 
    @Autowired
    private RatingsService ratingsService;

    @GetMapping
    public ResponseEntity<List<Customers>> getAllCustomers() {
        List<Customers> customers = customersService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getCustomerById(@PathVariable int customerId) {
        Optional<Customers> customer = customersService.getCustomerById(customerId);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Customer not found\"}");
        }
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> updateCustomer(@PathVariable int customerId,
                                                  @RequestBody Customers updatedCustomer) {
        try {
            Customers updated = customersService.updateCustomer(customerId, updatedCustomer);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Customer not found\"}");
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable int customerId) {
        try {
            customersService.deleteCustomer(customerId);
            return ResponseEntity.ok("{\"code\": \"DELETESUCCESS\", \"message\": \"Customer deleted successfully\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"DELETEFAIL\", \"message\": \"" + e.getMessage() + "\"}");
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
    public ResponseEntity<List<Ratings>> getReviewsByCustomer(@PathVariable int customerId) {
        List<Ratings> reviews = customersService.getReviewsByCustomer(customerId);
        return ResponseEntity.ok(reviews);
    }
    @PostMapping("/{customerId}/favorites")
    public ResponseEntity<String> addFavoriteRestaurant(@PathVariable int customerId, @RequestBody Restaurants restaurant) {
        try {
            customersService.addFavoriteRestaurant(customerId, restaurant);
            return ResponseEntity.status(HttpStatus.CREATED).body("Restaurant added to favorites successfully.");
        } catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while adding the restaurant to favorites.");
        }
    }
 
    
    @DeleteMapping("/{customerId}/favorites/{restaurantId}")
    public ResponseEntity<String> removeFavoriteRestaurant(
            @PathVariable int customerId,
            @PathVariable int restaurantId) {
    	
    	String response = customersService.removeFavoriteRestaurant(customerId, restaurantId);
        return ResponseEntity.ok(response);
    }
    }
    

  

