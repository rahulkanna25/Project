package com.service;

import com.model.Customers;
import com.DAO.CustomersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {
    @Autowired
    private CustomersDAO customersDAO;

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
		// TODO Auto-generated method stub
		return null;
	}

   
}
