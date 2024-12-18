package com.controller;

import com.model.Orders;
import com.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping
    public ResponseEntity<String> placeOrder(@RequestBody Orders order) {
        ordersService.placeOrder(order);
        return ResponseEntity.ok("Order placed successfully");
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Orders> getOrderDetails(@PathVariable int orderId) {
        Optional<Orders> order = ordersService.getOrderDetails(orderId);
        if (order.isPresent()) {
            return ResponseEntity.status(200).body(order.get());
        } else {
            return ResponseEntity.status(404).build();
        }
    }


    @PutMapping("/{orderId}/status")
    public ResponseEntity<String> updateOrderStatus(@PathVariable int orderId, @RequestBody String status) {
        try {
            ordersService.updateOrderStatus(orderId, status);
            return ResponseEntity.ok("Order status updated successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> cancelOrder(@PathVariable int orderId) {
        try {
            ordersService.cancelOrder(orderId);
            return ResponseEntity.ok("Order canceled successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
