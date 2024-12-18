package com.controller;

import com.model.Orders;
import com.service.OrdersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    // Place a new order
    @PostMapping
    public ResponseEntity<Object> placeOrder(@RequestBody Orders order) {
        try {
            ordersService.add(order);
            return ResponseEntity.ok("{\"code\": \"ORDERSUCCESS\", \"message\": \"Order placed successfully\"}");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("{\"code\": \"ORDERFAIL\", \"message\": \"Error placing the order\"}");
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Object> getOrderById(@PathVariable("orderId") int orderId) {
        List<Orders> ordersList = ordersService.getAll();
        for (Orders order : ordersList) {
            if (order.getOrder_id() == orderId) {
                return ResponseEntity.ok(order);
            }
        }
        return ResponseEntity.status(404).body("{\"code\": \"NOTFOUND\", \"message\": \"Order not found\"}");
    }

    // Update the status of a specific order
    @PutMapping("/{orderId}/status")
    public ResponseEntity<Object> updateOrderStatus(@PathVariable("orderId") int orderId, @RequestBody Orders updatedOrder) {
        List<Orders> ordersList = ordersService.getAll();
        for (Orders order : ordersList) {
            if (order.getOrder_id() == orderId) {
                order.setOrder_status(updatedOrder.getOrder_status());
                ordersService.update(order);
                return ResponseEntity.ok("{\"code\": \"UPDATESUCCESS\", \"message\": \"Order status updated successfully\"}");
            }
        }
        return ResponseEntity.status(404).body("{\"code\": \"NOTFOUND\", \"message\": \"Order not found\"}");
    }

    // Cancel a specific order
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> cancelOrder(@PathVariable("orderId") int orderId) {
        try {
            ordersService.delete(orderId);
            return ResponseEntity.ok("{\"code\": \"DELETESUCCESS\", \"message\": \"Order canceled successfully\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body("{\"code\": \"DELETEFAIL\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }

    // Retrieve all orders
    @GetMapping
    public ResponseEntity<Object> getAllOrders() {
        List<Orders> ordersList = ordersService.getAll();
        if (ordersList.isEmpty()) {
            return ResponseEntity.status(404).body("{\"code\": \"NOTFOUND\", \"message\": \"No orders found\"}");
        }
        return ResponseEntity.ok(ordersList);
    }
}
