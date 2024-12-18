package com.service;

import com.DAO.*;
import com.model.Orders;
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

    public Optional<Orders> getOrderDetails(int orderId) {
        return ordersDAO.findById(orderId);
    }

    public Orders updateOrderStatus(int orderId, String status) {
        Optional<Orders> existingOrder = ordersDAO.findById(orderId);
        if (existingOrder.isPresent()) {
            Orders order = existingOrder.get();
            order.setOrderStatus(status);
            return ordersDAO.save(order);
        } else {
            throw new RuntimeException("Order with ID " + orderId + " not found.");
        }
    }

    public void cancelOrder(int orderId) {
        if (ordersDAO.existsById(orderId)) {
            ordersDAO.deleteById(orderId);
        } else {
            throw new RuntimeException("Order with ID " + orderId + " not found.");
        }
    }
}
