package com.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.DAO.CustomersDAO;
import com.DAO.OrdersDAO;
import com.DAO.RatingsDAO;
import com.exception.OrderNotFoundException;
import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    @Autowired
    private CustomersDAO customersDAO;
    
    
    @Autowired
    private OrdersDAO orderDAO;
    
    
    @Autowired
    RatingsDAO ratingsDAO;
    

    public List<Customers> getAllCustomers() {
        return customersDAO.findAll();
    }

    public Optional<Customers> getCustomerById(int id) {
        return customersDAO.findById(id);
    }


    public void deleteCustomer(int id) {
        if (customersDAO.existsById(id)) {
            customersDAO.deleteById(id);
        } else {
            throw new RuntimeException("Customer not found");
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
            throw new OrderNotFoundException("Order with ID " + customerId + " not found.");
        }
    }
	
	
	public List<Orders> getOrdersByCustomerId(int customerId){
		
		if(customersDAO.existsById(customerId)) {
		
		return orderDAO.findByCustomerCustomerId(customerId);
		
		}else {
			
			throw new RuntimeException("Customer not found");
			
		}
		
	}
	
	public List<Ratings> getReviewsByCustomer(int customerId) {
   	 return ratingsDAO.findRatingsByCustomerId(customerId); 
   }
	
}
