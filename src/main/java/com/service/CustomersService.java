package com.service;

<<<<<<< HEAD


=======
import com.model.Customers;
import com.DAO.CustomersDAO; // Import your CustomersDAO
import com.DAO.OrdersDAO;
import com.DAO.RatingsDAO;
import com.model.Orders; // Assuming you have an Orders class
import com.model.Ratings; // Assuming you have a Ratings class
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

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
import java.util.ArrayList;
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

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

   /* public List<Orders> getOrdersByCustomer(int customerId) {
    }*/
    public List<Ratings> getReviewsByCustomer(int customerId) {
    	List<Orders> orderslist = ordersDAO.findByCustomer_CustomerId(customerId);         
    	List<Ratings> ratingList = new ArrayList<>();
    	for(Orders o: orderslist) {
    		ratingList.addAll(ratingsDAO.findByOrderId(o.getOrderId()));
    	}
    	return ratingList;
    }

    

    
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
}
