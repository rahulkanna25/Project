package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.CustomersDAO;
import com.DAO.OrdersDAO;
import com.DAO.RatingsDAO;
import com.DAO.RestaurantsDAO;
import com.exception.CustomerNotFoundException;
import com.exception.EmptyListException;
import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;
import com.model.Restaurants;

@Service
public class CustomersService {

    @Autowired
    private CustomersDAO customersDAO;
    

    
    @Autowired
    private OrdersDAO orderDAO;
    
    @Autowired
    RestaurantsDAO restaurantDAO;
    
    
    
    @Autowired
    private RatingsDAO ratingsDAO;
    @Autowired
    private OrdersDAO ordersDAO;


    public List<Customers> getAllCustomers() {
        return customersDAO.findAll(); 
    }

    public Optional<Customers> getCustomerById(int customerId) {
        return customersDAO.findById(customerId);
    }



    public void deleteCustomer(int id) {
        if (customersDAO.existsById(id)) {
            customersDAO.deleteById(id);
        }
    }

	public Customers updateCustomer(int customerId, Customers customerDetails) {
		
		Optional<Customers> existingCustomer = customersDAO.findById(customerId);
        if (existingCustomer.isPresent()) {
            Customers customer = existingCustomer.get();
            customer.setCustomerName(customerDetails.getCustomerName());
            customer.setCustomerPhone(customerDetails.getCustomerPhone());
            customer.setCustomerEmail(customerDetails.getCustomerEmail());
            return customersDAO.save(customer);
        } else {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
        }
    }
	
	
	public List<Orders> getOrdersByCustomerId(int customerId){
		
		if(customersDAO.existsById(customerId)) {
		
			List<Orders> ol = orderDAO.findByCustomer_CustomerId(customerId);
			
			if(ol.isEmpty()) {
				
				throw new EmptyListException("No orders placed by customer with ID " +customerId);
				
			}
			return ol;
		
		}else {
			
			throw new CustomerNotFoundException("Customer not found");
			
		}
		
	}
	
	public List<Ratings> getReviewsByCustomer(int customerId) {
		if(customersDAO.existsById(customerId)) {
			
		List<Ratings> rl = ratingsDAO.findRatingsByCustomerId(customerId); 
		if(rl.isEmpty()) {
			
			throw new EmptyListException("No reviews submitted by customer with ID " +customerId);
			
		}
		return rl;
	
	}
		else {
		
		throw new CustomerNotFoundException("Customer not found");
		
   }
	
	}
	
	

	    
	    public void addFavoriteRestaurant(int customerId, Restaurants restaurant) {
	        
	        Optional<Customers> customerOpt = customersDAO.findById(customerId);
	        

	        if (customerOpt.isPresent()) {
	            Customers customer = customerOpt.get();

	            customer.getFavouriteRestaurants().add(restaurant);
	            customersDAO.save(customer); 
	           
	            
	        } else {
	            throw new CustomerNotFoundException("Customer not found!");
	        }
	    }

	    
	    public String removeFavoriteRestaurant(int customerId, int restaurantId) {
	        Optional<Customers> customerOpt = customersDAO.findById(customerId);
	        Optional<Restaurants> restaurantOpt = restaurantDAO.findById(restaurantId);

	        if (customerOpt.isPresent() && restaurantOpt.isPresent()) {
	            Customers customer = customerOpt.get();
	            Restaurants restaurant = restaurantOpt.get();

	            
	            customer.getFavouriteRestaurants().remove(restaurant);
	            customersDAO.save(customer); 

	            return "Restaurant removed from favorites successfully!";
	        } else {
	            throw new CustomerNotFoundException("Customer or Restaurant doesn't exists");
	        }
	    }
	

   
    

}  

    



