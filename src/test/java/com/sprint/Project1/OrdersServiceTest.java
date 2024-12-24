package com.sprint.Project1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.DAO.CustomersDAO;
import com.DAO.DeliveryDriverDAO;
import com.DAO.OrdersDAO;
import com.DAO.RestaurantsDAO;
import com.exception.DriverNotFoundException;
import com.exception.OrderNotFoundException;
import com.model.Customers;
import com.model.DeliveryDrivers;
import com.model.Orders;
import com.model.Restaurants;
import com.service.OrdersService;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class OrdersServiceTest {

    @InjectMocks
    private OrdersService ordersService;

    @Mock
    private OrdersDAO ordersDAO;

    @Mock
    private DeliveryDriverDAO deliveryDriverDAO;

    @Mock
    private RestaurantsDAO restaurantDAO;

    @Mock
    private CustomersDAO customerDAO;

    private Orders order;
    private DeliveryDrivers driver;
    private Restaurants restaurant;
    private Customers customer;

    @BeforeEach
    void setup() {
        driver = new DeliveryDrivers();
        driver.setDriverId(1);

        restaurant = new Restaurants();
        restaurant.setRestaurantId(1);

        customer = new Customers();
        customer.setCustomerId(1);

        order = new Orders();
        order.setOrderId(1);
        order.setDeliveryDriver(driver);
        order.setRestaurant(restaurant);
        order.setCustomer(customer);
    }

    @Test
    void testAddOrder_success() {
        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.of(driver));
        when(restaurantDAO.findById(1)).thenReturn(Optional.of(restaurant));
        when(customerDAO.findById(1)).thenReturn(Optional.of(customer));
        when(ordersDAO.save(order)).thenReturn(order);

        Orders savedOrder = ordersService.addOrder(order);

        assertNotNull(savedOrder);
        assertEquals(1, savedOrder.getDeliveryDriver().getDriverId());
        assertEquals(1, savedOrder.getRestaurant().getRestaurantId());
        assertEquals(1, savedOrder.getCustomer().getCustomerId());
    }

    @Test
    void testAddOrder_driverNotFound() {
        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(DriverNotFoundException.class, () -> ordersService.addOrder(order));
        assertEquals("Driver not found with id: 1", exception.getMessage());
    }

    @Test
    void testAddOrder_restaurantNotFound() {
        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.of(driver));
        when(restaurantDAO.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> ordersService.addOrder(order));
        assertEquals("Restaurant not found with id: 1", exception.getMessage());
    }

    @Test
    void testAddOrder_customerNotFound() {
        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.of(driver));
        when(restaurantDAO.findById(1)).thenReturn(Optional.of(restaurant));
        when(customerDAO.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> ordersService.addOrder(order));
        assertEquals("Customer not found with id: 1", exception.getMessage());
    }

    @Test
    void testGetOrderDetails_success() {
        when(ordersDAO.findById(1)).thenReturn(Optional.of(order));

        Orders foundOrder = ordersService.getOrderDetails(1);

        assertNotNull(foundOrder);
        assertEquals(1, foundOrder.getOrderId());
    }

    @Test
    void testGetOrderDetails_notFound() {
        when(ordersDAO.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(OrderNotFoundException.class, () -> ordersService.getOrderDetails(1));
        assertEquals("Order with ID 1 not found.", exception.getMessage());
    }

    @Test
    void testUpdateOrderStatus_success() {
        when(ordersDAO.findById(1)).thenReturn(Optional.of(order));
        when(ordersDAO.save(order)).thenReturn(order);

        Orders updatedOrder = ordersService.updateOrderStatus(1, "Delivered");

        assertNotNull(updatedOrder);
        assertEquals("Delivered", updatedOrder.getOrderStatus());
    }

    @Test
    void testUpdateOrderStatus_notFound() {
        when(ordersDAO.findById(1)).thenReturn(Optional.empty());

        Exception exception = assertThrows(OrderNotFoundException.class, () -> ordersService.updateOrderStatus(1, "Delivered"));
        assertEquals("Order with ID 1 not found.", exception.getMessage());
    }

    @Test
    void testCancelOrder_success() {
        when(ordersDAO.existsById(1)).thenReturn(true);
        doNothing().when(ordersDAO).deleteById(1);

        assertDoesNotThrow(() -> ordersService.cancelOrder(1));
        verify(ordersDAO, times(1)).deleteById(1);
    }

    @Test
    void testCancelOrder_notFound() {
        when(ordersDAO.existsById(1)).thenReturn(false);

        Exception exception = assertThrows(OrderNotFoundException.class, () -> ordersService.cancelOrder(1));
        assertEquals("Order with ID 1 not found.", exception.getMessage());
    }
}

 