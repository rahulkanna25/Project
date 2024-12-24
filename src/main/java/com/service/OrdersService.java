package com.service;

<<<<<<< HEAD


=======
import com.model.Customers;
import com.model.Orders;
import com.DAO.OrdersDAO; // Import your OrdersDAO
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

<<<<<<< HEAD
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

=======
import java.util.List;
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
<<<<<<< HEAD
    private OrdersDAO ordersDAO;
    
    @Autowired
    private DeliveryDriverDAO deliveryDriverDAO;
    
    
    @Autowired
    private RestaurantsDAO restaurantDAO;
    
    
    @Autowired
    private CustomersDAO customerDAO;
    
    
    
    

    public Orders addOrder(Orders order) {
    	
    Optional <DeliveryDrivers> driver = deliveryDriverDAO.findById(order.getDeliveryDriver().getDriver_id());
                if(!driver.isPresent()) {
                
                
                throw new DriverNotFoundException("Driver not found with id: " + order.getDeliveryDriver().getDriver_id());
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
=======
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
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
        }
    }

    public void cancelOrder(int orderId) {
        if (ordersDAO.existsById(orderId)) {
<<<<<<< HEAD
            ordersDAO.deleteById(orderId);
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found.");
        }
    }
=======
            ordersDAO.deleteById(orderId); // Delete the order from the database
        } else {
            throw new RuntimeException("Order not found"); // Handle case where order does not exist
        }
    }
    
    public List<Orders> getCustomer(int customerId){
    	return ordersDAO.findByCustomer_CustomerId(customerId);
    }
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
}
