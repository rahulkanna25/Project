package com.service;


import com.model.Customers;

import com.model.Orders;
import com.DAO.OrdersDAO; // Import your OrdersDAO

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.DAO.CustomersDAO;
import com.DAO.DeliveryDriverDAO;
import com.DAO.OrdersDAO;
import com.DAO.RestaurantsDAO;
import com.exception.CustomerNotFoundException;
import com.exception.DriverNotFoundException;
import com.exception.OrderNotFoundException;
import com.exception.RestaurantNotFoundException;
import com.model.Customers;
import com.model.DeliveryDrivers;
import com.model.Orders;
import com.model.Restaurants;


@Service
public class OrdersService {

    @Autowired

    private OrdersDAO ordersDAO;
    
    @Autowired
    private DeliveryDriverDAO deliveryDriverDAO;
    
    
    @Autowired
    private RestaurantsDAO restaurantDAO;
    
    
    @Autowired
    private CustomersDAO customerDAO;
    
    
    
    

    public Orders addOrder(Orders order) {
    	
    Optional <DeliveryDrivers> driver = deliveryDriverDAO.findById(order.getDeliveryDriver().getDriverId());
                if(!driver.isPresent()) {
                
                
                throw new DriverNotFoundException("Driver not found with id: " + order.getDeliveryDriver().getDriverId());
                }
                   else {
        
        order.setDeliveryDriver(driver.get());
                }
    Optional <Restaurants> restaurant = restaurantDAO.findById(order.getRestaurant().getRestaurantId());
            if(!restaurant.isPresent()) {
   
   

               throw  new RestaurantNotFoundException("Restaurant not found with id: " + order.getRestaurant().getRestaurantId());

                  
            }else {
        
        order.setRestaurant(restaurant.get());
            }
       Optional <Customers> customer = customerDAO.findById(order.getCustomer().getCustomerId());
       
       if(!customer.isPresent()) {
                throw new CustomerNotFoundException("Customer not found with id: " + order.getCustomer().getCustomerId());
       }else {
        
        order.setCustomer(customer.get());
       }
        
        return ordersDAO.save(order);
        
    	
    }
    public Orders getOrderDetails(int orderId) {
    	 Optional<Orders> existingOrder = ordersDAO.findById(orderId);
         if (existingOrder.isPresent()) {
         return existingOrder.get();
         }else {
        	 throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
         }
         
    }

    public Orders updateOrderStatus(int orderId, String status) {
        Optional<Orders> existingOrder = ordersDAO.findById(orderId);
        if (existingOrder.isPresent()) {
            Orders order = existingOrder.get();
            order.setOrderStatus(status);
            return ordersDAO.save(order);
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");

        }
    }
        
    public void cancelOrder(int orderId) {
        if (ordersDAO.existsById(orderId)) {

            ordersDAO.deleteById(orderId);
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
        }
    }

    public List<Orders> getCustomer(int customerId){
    	return ordersDAO.findByCustomer_CustomerId(customerId);
    }

}
