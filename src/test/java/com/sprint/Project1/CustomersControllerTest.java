package com.sprint.Project1;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.controller.CustomersController;
import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;
import com.service.CustomersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomersControllerTest {

    @InjectMocks
    private CustomersController customersController;

    @Mock
    private CustomersService customersService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCustomers() {
        List<Customers> customersList = new ArrayList<>();
        customersList.add(new Customers());

        when(customersService.getAllCustomers()).thenReturn(customersList);

        List<Customers> result = customersController.getAllCustomers();

        assertEquals(1, result.size());
        verify(customersService, times(1)).getAllCustomers();
    }

    @Test
    public void testGetCustomerById_WhenCustomerExists() {
        Customers customer = new Customers();

        when(customersService.getCustomerById(1)).thenReturn(Optional.of(customer));

        ResponseEntity<Customers> response = customersController.getCustomerById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    public void testGetCustomerById_WhenCustomerDoesNotExist() {
        when(customersService.getCustomerById(1)).thenReturn(Optional.empty());

        ResponseEntity<Customers> response = customersController.getCustomerById(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testUpdateCustomer_WhenCustomerExists() {
        Customers updatedCustomer = new Customers();

        when(customersService.updateCustomer(eq(1), any(Customers.class))).thenReturn(updatedCustomer);

        ResponseEntity<Customers> response = customersController.updateCustomer(1, new Customers());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCustomer, response.getBody());
    }

    @Test
    public void testUpdateCustomer_WhenCustomerDoesNotExist() {
        when(customersService.updateCustomer(eq(1), any(Customers.class))).thenThrow(RuntimeException.class);

        ResponseEntity<Customers> response = customersController.updateCustomer(1, new Customers());

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void testGetOrdersByCustomerId_WhenOrdersExist() {
        List<Orders> ordersList = new ArrayList<>();
        ordersList.add(new Orders());

        when(customersService.getOrdersByCustomerId(1)).thenReturn(ordersList);

        ResponseEntity<?> response = customersController.getOrdersByCustomerId(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ordersList, response.getBody());
    }

    @Test
    public void testGetOrdersByCustomerId_WhenOrdersDoNotExist() {
        when(customersService.getOrdersByCustomerId(1)).thenThrow(RuntimeException.class);

        ResponseEntity<?> response = customersController.getOrdersByCustomerId(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("No reviews found", response.getBody());
    }

    @Test
    public void testGetRatingsByCustomerId_WhenRatingsExist() {
        List<Ratings> ratingsList = new ArrayList<>();
        ratingsList.add(new Ratings());

        when(customersService.getReviewsByCustomer(1)).thenReturn(ratingsList);

        ResponseEntity<?> response = customersController.getRatingsByCustomerId(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ratingsList, response.getBody());
    }

    @Test
    public void testGetRatingsByCustomerId_WhenRatingsDoNotExist() {
        when(customersService.getReviewsByCustomer(1)).thenThrow(RuntimeException.class);

        ResponseEntity<?> response = customersController.getRatingsByCustomerId(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Customer not found", response.getBody());
    }

    @Test
    public void testDeleteCustomer_WhenCustomerExists() {
        doNothing().when(customersService).deleteCustomer(1);

        ResponseEntity<String> response = customersController.deleteCustomer(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Customer deleted successfully", response.getBody());
    }

    @Test
    public void testDeleteCustomer_WhenCustomerDoesNotExist() {
        doThrow(RuntimeException.class).when(customersService).deleteCustomer(1);

        ResponseEntity<String> response = customersController.deleteCustomer(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Customer not found", response.getBody());
    }
}

