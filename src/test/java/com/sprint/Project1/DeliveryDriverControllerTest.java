package com.sprint.Project1;
 
import com.controller.DeliveryDriverController;
import com.model.DeliveryDrivers;
import com.model.Orders;
import com.service.DeliveryDriverService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
 
import java.util.Arrays;
import java.util.List;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
 
public class DeliveryDriverControllerTest {
 
    @InjectMocks
    private DeliveryDriverController deliveryDriverController;
 
    @Mock
    private DeliveryDriverService deliveryDriverService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    // Test: Get All Drivers
    @Test
    public void testGetDrivers() {
        List<DeliveryDrivers> mockDrivers = Arrays.asList(
                new DeliveryDrivers(1, "John Doe", "1234567890", "Car", null),
                new DeliveryDrivers(2, "Jane Smith", "9876543210", "Bike", null)
        );
 
        when(deliveryDriverService.getAll()).thenReturn(mockDrivers);
 
        ResponseEntity<?> response = deliveryDriverController.getDrivers();
 
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockDrivers, response.getBody());
        verify(deliveryDriverService, times(1)).getAll();
    }
 
    // Test: Get a Single Driver
    @Test
    public void testGetDriver() {
        int driverId = 1;
        DeliveryDrivers mockDriver = new DeliveryDrivers();
 
        when(deliveryDriverService.getDriver(driverId)).thenReturn(mockDriver);
 
        ResponseEntity<?> response = deliveryDriverController.getDriver(driverId);
 
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockDriver, response.getBody());
        verify(deliveryDriverService, times(1)).getDriver(driverId);
    }
 
    // Test: Assign an Order to a Driver
    @Test
    public void testAssignOrders() {
        int driverId = 1;
        int orderId = 101;
 
        doNothing().when(deliveryDriverService).assignOrder(orderId, driverId);
 
        ResponseEntity<?> response = deliveryDriverController.assignOrders(driverId, orderId);
 
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Order Assigned", response.getBody());
        verify(deliveryDriverService, times(1)).assignOrder(orderId, driverId);
    }
 
    // Test: Update Driver's Location
    @Test
    public void testUpdateLocation() {
        int driverId = 1;
        String location = "New York";
 
        doNothing().when(deliveryDriverService).updateLocation(driverId, location);
 
        ResponseEntity<?> response = deliveryDriverController.updateLocation(driverId, location);
 
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Location Updated", response.getBody());
        verify(deliveryDriverService, times(1)).updateLocation(driverId, location);
    }
 
    // Test: Get All Orders Assigned to a Driver
    @Test
    public void testGetOrders() {
        int driverId = 1;
        List<Orders> mockOrders = Arrays.asList(
                new Orders(),
                new Orders()
        );
 
        when(deliveryDriverService.allOrders(driverId)).thenReturn(mockOrders);
 
        ResponseEntity<?> response = deliveryDriverController.getOrders(driverId);
 
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockOrders, response.getBody());
        verify(deliveryDriverService, times(1)).allOrders(driverId);
    }
}
 
 