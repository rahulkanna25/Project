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
    

    public Customers findById(int id) {
        return customersDAO.findById(id).orElse(null);
    }

    public void save(Customers customer) {
        customersDAO.save(customer);
    }

    public List<Customers> getAllCustomers() {
        List<Customers> cl = customersDAO.findAll(); 
        if(cl.isEmpty()) {
        	throw new EmptyListException("No Customers Found");
        }
        return cl;
    }

    public Customers getCustomerById(int customerId) {
    	Optional<Customers> customer = customersDAO.findById(customerId);
    	if(!customer.isPresent()) {
    		throw new CustomerNotFoundException("Customer with ID " + customerId + " not found.");
    	}
    	return customer.get();
    }



    public void deleteCustomer(int id) {
        if (customersDAO.existsById(id)) {
            customersDAO.deleteById(id);
        }else {
        	throw new CustomerNotFoundException("Customer with ID " + id + " not found.");
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
        Optional<Restaurants> restaurantOpt = restaurantDAO.findById(restaurant.getRestaurantId());
        
        System.out.println("Restaurant ID from request: " + restaurant.getRestaurantId());
        

        if (!customerOpt.isPresent()) {
        	throw new EmptyListException("Customer not found!");
        	
        }
        if (!restaurantOpt.isPresent()) {
        	throw new EmptyListException("restaurant not found!");
        	
        }else {
        
            Customers customer = customerOpt.get();
            Restaurants restaurantobj  = restaurantOpt.get();

            customer.getFavouriteRestaurants().add(restaurantobj);
            customersDAO.save(customer); 
           
            
        } 
    }

    
<<<<<<< HEAD
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
            throw new EmptyListException("Customer or Restaurant doesn't exists");
=======
           
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
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
        }
    }


	
}

	

	
