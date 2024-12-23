package com.sprint.Project1;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.DAO.DeliveryDriverDAO;
import com.DAO.OrdersDAO;
import com.exception.DriverNotFoundException;
import com.exception.EmptyListException;
import com.exception.OrderNotFoundException;
import com.model.DeliveryDrivers;
import com.model.Orders;
import com.service.DeliveryDriverService;

public class DeliveryDriverServiceTest {

    @InjectMocks
    private DeliveryDriverService deliveryDriverService;

    @Mock
    private DeliveryDriverDAO deliveryDriverDAO;

    @Mock
    private OrdersDAO ordersDAO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDrivers_WhenDriversExist() {
        List<DeliveryDrivers> drivers = new ArrayList<>();
        drivers.add(new DeliveryDrivers());

        when(deliveryDriverDAO.findAll()).thenReturn(drivers);

        List<DeliveryDrivers> result = deliveryDriverService.getAll();

        assertEquals(1, result.size());
        verify(deliveryDriverDAO, times(1)).findAll();
    }

    @Test
    public void testGetAllDrivers_WhenNoDriversExist() {
        when(deliveryDriverDAO.findAll()).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> deliveryDriverService.getAll());
        verify(deliveryDriverDAO, times(1)).findAll();
    }

    @Test
    public void testGetDriver_WhenDriverExists() {
        DeliveryDrivers driver = new DeliveryDrivers();
        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.of(driver));

        DeliveryDrivers result = deliveryDriverService.getDriver(1);

        assertNotNull(result);
        verify(deliveryDriverDAO, times(1)).findById(1);
    }

    @Test
    public void testGetDriver_WhenDriverDoesNotExist() {
        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(DriverNotFoundException.class, () -> deliveryDriverService.getDriver(1));
        verify(deliveryDriverDAO, times(1)).findById(1);
    }

    @Test
    public void testAssignOrder_WhenDriverAndOrderExist() {
        Orders order = new Orders();
        DeliveryDrivers driver = new DeliveryDrivers();

        when(ordersDAO.findById(1)).thenReturn(Optional.of(order));
        when(deliveryDriverDAO.findById(2)).thenReturn(Optional.of(driver));

        deliveryDriverService.assignOrder(1, 2);

        assertEquals(driver, order.getDeliveryDriver());
        verify(ordersDAO, times(1)).save(order);
    }

    @Test
    public void testAssignOrder_WhenDriverDoesNotExist() {
        Orders order = new Orders();

        when(ordersDAO.findById(1)).thenReturn(Optional.of(order));
        when(deliveryDriverDAO.findById(2)).thenReturn(Optional.empty());

        assertThrows(DriverNotFoundException.class, () -> deliveryDriverService.assignOrder(1, 2));
    }

    @Test
    public void testAssignOrder_WhenOrderDoesNotExist() {
        DeliveryDrivers driver = new DeliveryDrivers();

        when(ordersDAO.findById(1)).thenReturn(Optional.empty());
        when(deliveryDriverDAO.findById(2)).thenReturn(Optional.of(driver));

        assertThrows(OrderNotFoundException.class, () -> deliveryDriverService.assignOrder(1, 2));
    }

    @Test
    public void testAllOrders_WhenOrdersExist() {
        DeliveryDrivers driver = new DeliveryDrivers();
        List<Orders> orders = new ArrayList<>();
        orders.add(new Orders());

        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.of(driver));
        when(ordersDAO.findByDeliveryDriverDriverid(1)).thenReturn(orders);

        List<Orders> result = deliveryDriverService.allOrders(1);

        assertEquals(1, result.size());
        verify(ordersDAO, times(1)).findByDeliveryDriverDriverid(1);
    }

    @Test
    public void testAllOrders_WhenNoOrdersExist() {
        DeliveryDrivers driver = new DeliveryDrivers();

        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.of(driver));
        when(ordersDAO.findByDeliveryDriverDriverid(1)).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> deliveryDriverService.allOrders(1));
    }

    @Test
    public void testUpdateLocation_WhenDriverExists() {
        DeliveryDrivers driver = new DeliveryDrivers();

        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.of(driver));

        deliveryDriverService.updateLocation(1, "New Location");

        assertEquals("New Location", driver.getDriverLocation());
        verify(deliveryDriverDAO, times(1)).save(driver);
    }

    @Test
    public void testUpdateLocation_WhenDriverDoesNotExist() {
        when(deliveryDriverDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(DriverNotFoundException.class, () -> deliveryDriverService.updateLocation(1, "New Location"));
    }
}
