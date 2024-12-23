package com.controller;

<<<<<<< HEAD
=======
import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;
import com.service.CustomersService;
import com.service.RatingsService;
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc

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
<<<<<<< HEAD
    private CustomersService customersService;
    
    
=======
    private CustomersService customersService; 
    @Autowired
    private RatingsService ratingsService;

>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
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
    public ResponseEntity<Object> deleteCustomer(@PathVariable int customerId) {
        try {
            customersService.deleteCustomer(customerId);
            return ResponseEntity.ok("{\"code\": \"DELETESUCCESS\", \"message\": \"Customer deleted successfully\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"DELETEFAIL\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }

   /* @GetMapping("/{customerId}/orders")
    public ResponseEntity<List<Orders>> getOrdersByCustomer(@PathVariable int customerId) {
        List<Orders> orders = customersService.getOrdersByCustomer(customerId);
        return ResponseEntity.ok(orders);
    }*/

    @GetMapping("/{customerId}/reviews")
    public ResponseEntity<List<Ratings>> getReviewsByCustomer(@PathVariable int customerId) {
        List<Ratings> reviews = customersService.getReviewsByCustomer(customerId);
        return ResponseEntity.ok(reviews);
    }
    

  
}
