package com.service;

import com.model.Customers;
import com.DAO.CustomersDAO; 
import com.DAO.OrdersDAO;
import com.DAO.RatingsDAO;
import com.DAO.RestaurantsDAO;
import com.model.Orders; 
import com.model.Ratings; 
import com.model.Restaurants;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
	
	@Autowired
	private RestaurantsDAO restaurantsDAO;

    @Autowired
    private CustomersDAO customersDAO;
    
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

    public Customers updateCustomer(int customerId, Customers updatedCustomer) {
        if (customersDAO.existsById(customerId)) {
            updatedCustomer.setCustomerId(customerId); 
            return customersDAO.save(updatedCustomer); 
        } else {
            throw new RuntimeException("Customer not found");
        }
    }

    public void deleteCustomer(int customerId) {
        if (customersDAO.existsById(customerId)) {
            customersDAO.deleteById(customerId); 
        } else {
            throw new RuntimeException("Customer not found"); 
        }
    }

public List<Orders> getOrdersByCustomerId(int customerId){
		
		if(customersDAO.existsById(customerId)) {
		
			List<Orders> ol = ordersDAO.findByCustomer_CustomerId(customerId);
			
			if(ol.isEmpty()) {
				
				throw new EmptyListException("No orders placed by customer with ID " +customerId);
				
			}
			return ol;
		
		}else {
			
			throw new CustomerNotFoundException("Customer not found");
			
		}
		
	}
	
    public List<Ratings> getReviewsByCustomer(int customerId) {
    	List<Orders> orderslist = ordersDAO.findByCustomer_CustomerId(customerId);         
    	List<Ratings> ratingList = new ArrayList<>();
    	for(Orders o: orderslist) {
    		ratingList.addAll(ratingsDAO.findByOrderId(o.getOrderId()));
    	}
    	return ratingList;
    }
    
   

        @Autowired
        private CustomersDAO customerRepository;

        public Customers findById(int id) {
            return customerRepository.findById(id).orElse(null);
        }

        public void save(Customers customer) {
            customerRepository.save(customer);
        }
        
        
        public void addFavoriteRestaurant(int customerId, Restaurants restaurant) {
            
            Optional<Customers> customerOpt = customersDAO.findById(customerId);
            Optional<Restaurants> restaurantOpt = restaurantsDAO.findById(restaurant.getRestaurantId());
            
            System.out.println("Restaurant ID from request: " + restaurant.getRestaurantId());
            
     
            if (!customerOpt.isPresent()) {
            	throw new EmptyListException("Customer not found!");
            	
            }
            if (!restaurantOpt.isPresent()) {
            	throw new EmptyListException("restaurant not found!");
            	
            }else {
            
                Customers customer = customerOpt.get();
                Restaurants restaurantobj  = restaurantOpt.get();
     
                customer.getFavoriteRestaurants().add(restaurantobj);
                customersDAO.save(customer);
               
                
            }
        }
     
        
        public String removeFavoriteRestaurant(int customerId, int restaurantId) {
            Optional<Customers> customerOpt = customersDAO.findById(customerId);
            Optional<Restaurants> restaurantOpt = restaurantsDAO.findById(restaurantId);
     
            if (customerOpt.isPresent() && restaurantOpt.isPresent()) {
                Customers customer = customerOpt.get();
                Restaurants restaurant = restaurantOpt.get();
     
                
                customer.getFavoriteRestaurants().remove(restaurant);
                customersDAO.save(customer);
     
                return "Restaurant removed from favorites successfully!";
            } else {
                throw new EmptyListException("Customer or Restaurant doesn't exists");
            }
        }
    }


    

    

