package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.DeliveryDriverDAO;
import com.DAO.OrdersDAO;
import com.exception.DriverNotFoundException;
import com.exception.OrderNotFoundException;
import com.model.DeliveryDrivers;
import com.model.Orders;

import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersDAO ordersDAO;
    
    @Autowired
    private DeliveryDriverDAO ddao;

    public Orders addOrder(Orders order) {
        
        DeliveryDrivers driver = ddao.findById(order.getDeliveryDriver().getDriver_id())
                .orElseThrow(() -> new DriverNotFoundException("Driver not found with id: " + order.getDeliveryDriver().getDriver_id()));
        
        
        order.setDeliveryDriver(driver);
        
        
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
}
