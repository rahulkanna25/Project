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

import com.DAO.CustomersDAO;
import com.DAO.OrdersDAO;
import com.DAO.RatingsDAO;
import com.exception.CustomerNotFoundException;
import com.exception.EmptyListException;
import com.exception.OrderNotFoundException;
import com.model.Customers;
import com.model.Orders;
import com.model.Ratings;
import com.service.CustomersService;

public class CustomersServiceTest {

    @InjectMocks
    private CustomersService customersService;

    @Mock
    private CustomersDAO customersDAO;

    @Mock
    private OrdersDAO ordersDAO;

    @Mock
    private RatingsDAO ratingsDAO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllCustomers_WhenCustomersExist() {
        List<Customers> customers = new ArrayList<>();
        customers.add(new Customers());

        when(customersDAO.findAll()).thenReturn(customers);

        List<Customers> result = customersService.getAllCustomers();

        assertEquals(1, result.size());
        verify(customersDAO, times(1)).findAll();
    }

    @Test
    public void testGetAllCustomers_WhenNoCustomersExist() {
        when(customersDAO.findAll()).thenReturn(new ArrayList<>());

        List<Customers> result = customersService.getAllCustomers();

        assertTrue(result.isEmpty());
        verify(customersDAO, times(1)).findAll();
    }

    @Test
    public void testGetCustomerById_WhenCustomerExists() {
        Customers customer = new Customers();
        when(customersDAO.findById(1)).thenReturn(Optional.of(customer));

        Optional<Customers> result = customersService.getCustomerById(1);

        assertTrue(result.isPresent());
        assertEquals(customer, result.get());
        verify(customersDAO, times(1)).findById(1);
    }

    @Test
    public void testGetCustomerById_WhenCustomerDoesNotExist() {
        when(customersDAO.findById(1)).thenReturn(Optional.empty());

        Optional<Customers> result = customersService.getCustomerById(1);

        assertFalse(result.isPresent());
        verify(customersDAO, times(1)).findById(1);
    }

    @Test
    public void testDeleteCustomer_WhenCustomerExists() {
        when(customersDAO.existsById(1)).thenReturn(true);

        customersService.deleteCustomer(1);

        verify(customersDAO, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteCustomer_WhenCustomerDoesNotExist() {
        when(customersDAO.existsById(1)).thenReturn(false);

        assertThrows(CustomerNotFoundException.class, () -> customersService.deleteCustomer(1));
        verify(customersDAO, never()).deleteById(1);
    }

    @Test
    public void testUpdateCustomer_WhenCustomerExists() {
        Customers existingCustomer = new Customers();
        Customers updatedDetails = new Customers();
        updatedDetails.setCustomerName("Updated Name");
        updatedDetails.setCustomerPhone("1234567890");
        updatedDetails.setCustomerEmail("updated@example.com");

        when(customersDAO.findById(1)).thenReturn(Optional.of(existingCustomer));
        when(customersDAO.save(existingCustomer)).thenReturn(existingCustomer);

        Customers result = customersService.updateCustomer(1, updatedDetails);

        assertEquals("Updated Name", result.getCustomerName());
        assertEquals("1234567890", result.getCustomerPhone());
        assertEquals("updated@example.com", result.getCustomerEmail());
        verify(customersDAO, times(1)).save(existingCustomer);
    }

    @Test
    public void testUpdateCustomer_WhenCustomerDoesNotExist() {
        Customers updatedDetails = new Customers();

        when(customersDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customersService.updateCustomer(1, updatedDetails));
    }

    @Test
    public void testGetOrdersByCustomerId_WhenOrdersExist() {
        List<Orders> orders = new ArrayList<>();
        orders.add(new Orders());

        when(customersDAO.existsById(1)).thenReturn(true);
        when(ordersDAO.findByCustomer_CustomerId(1)).thenReturn(orders);

        List<Orders> result = customersService.getOrdersByCustomerId(1);

        assertEquals(1, result.size());
        verify(ordersDAO, times(1)).findByCustomer_CustomerId(1);
    }

    @Test
    public void testGetOrdersByCustomerId_WhenNoOrdersExist() {
        when(customersDAO.existsById(1)).thenReturn(true);
        when(ordersDAO.findByCustomer_CustomerId(1)).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> customersService.getOrdersByCustomerId(1));
    }

    @Test
    public void testGetOrdersByCustomerId_WhenCustomerDoesNotExist() {
        when(customersDAO.existsById(1)).thenReturn(false);

        assertThrows(CustomerNotFoundException.class, () -> customersService.getOrdersByCustomerId(1));
    }

    @Test
    public void testGetReviewsByCustomer_WhenReviewsExist() {
        List<Ratings> ratings = new ArrayList<>();
        ratings.add(new Ratings());

        when(customersDAO.existsById(1)).thenReturn(true);
        when(ratingsDAO.findRatingsByCustomerId(1)).thenReturn(ratings);

        List<Ratings> result = customersService.getReviewsByCustomer(1);

        assertEquals(1, result.size());
        verify(ratingsDAO, times(1)).findRatingsByCustomerId(1);
    }

    @Test
    public void testGetReviewsByCustomer_WhenNoReviewsExist() {
        when(customersDAO.existsById(1)).thenReturn(true);
        when(ratingsDAO.findRatingsByCustomerId(1)).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> customersService.getReviewsByCustomer(1));
    }

    @Test
    public void testGetReviewsByCustomer_WhenCustomerDoesNotExist() {
        when(customersDAO.existsById(1)).thenReturn(false);

        assertThrows(CustomerNotFoundException.class, () -> customersService.getReviewsByCustomer(1));
    }
}

