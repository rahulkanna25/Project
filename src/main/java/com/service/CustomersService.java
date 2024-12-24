package com.service;

<<<<<<< HEAD


=======
import com.model.Customers;
import com.DAO.CustomersDAO; 
import com.DAO.OrdersDAO;
import com.DAO.RatingsDAO;
<<<<<<< HEAD
import com.model.Orders; // Assuming you have an Orders class
import com.model.Ratings; // Assuming you have a Ratings class
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======
import com.DAO.RestaurantsDAO;
import com.model.Orders; 
import com.model.Ratings; 
import com.model.Restaurants;

>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
<<<<<<< HEAD

<<<<<<< HEAD
import com.DAO.CustomersDAO;
import com.DAO.OrdersDAO;
import com.DAO.RatingsDAO;
import com.exception.CustomerNotFoundException;
import com.exception.EmptyListException;
import com.exception.OrderNotFoundException;
import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;

=======
=======
import com.exception.*;
>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
import java.util.ArrayList;
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
	
	@Autowired
	private RestaurantsDAO restaurantsDAO;

    @Autowired
    private CustomersDAO customersDAO;
    
<<<<<<< HEAD
    
    @Autowired
    private OrdersDAO orderDAO;
    
    
    @Autowired
    RatingsDAO ratingsDAO;
    
=======
    @Autowired
    private RatingsDAO ratingsDAO;
    @Autowired
    private OrdersDAO ordersDAO;
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447

    public List<Customers> getAllCustomers() {
        return customersDAO.findAll(); 
    }

    public Optional<Customers> getCustomerById(int customerId) {
        return customersDAO.findById(customerId);
    }

<<<<<<< HEAD

    public void deleteCustomer(int id) {
        if (customersDAO.existsById(id)) {
            customersDAO.deleteById(id);
=======
    public Customers updateCustomer(int customerId, Customers updatedCustomer) {
        if (customersDAO.existsById(customerId)) {
            updatedCustomer.setCustomerId(customerId); 
            return customersDAO.save(updatedCustomer); 
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
        } else {
            throw new CustomerNotFoundException("Customer not found");
        }
    }

<<<<<<< HEAD
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
		
			List<Orders> ol = orderDAO.findByCustomerCustomerId(customerId);
			
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
=======
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


    

    
<<<<<<< HEAD
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
}
=======

>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
