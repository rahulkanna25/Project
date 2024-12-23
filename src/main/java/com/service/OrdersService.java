package com.service;

import com.model.Customers;
import com.model.Orders;
import com.DAO.OrdersDAO; // Import your OrdersDAO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersDAO ordersDAO; 

    public Orders placeOrder(Orders order) {
        return ordersDAO.save(order); 
    }

    public Optional<Orders> getOrderById(int orderId) {
        return ordersDAO.findById(orderId);
    }

    public Orders updateOrderStatus(int orderId, String newStatus) {
        Optional<Orders> optionalOrder = ordersDAO.findById(orderId);
        if (optionalOrder.isPresent()) {
            Orders order = optionalOrder.get();
            order.setOrderStatus(newStatus); 
            return ordersDAO.save(order); // Save updated order
        } else {
            throw new RuntimeException("Order not found"); // Handle case where order does not exist
        }
    }

    public void cancelOrder(int orderId) {
        if (ordersDAO.existsById(orderId)) {
            ordersDAO.deleteById(orderId); // Delete the order from the database
        } else {
            throw new RuntimeException("Order not found"); // Handle case where order does not exist
        }
    }
    
    public List<Orders> getCustomer(int customerId){
    	return ordersDAO.findByCustomer_CustomerId(customerId);
    }
}
