package com.sprint.Project1;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.model.Orders;
import com.service.OrdersService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.controller.OrdersController;
import com.fasterxml.jackson.databind.ObjectMapper;

class OrdersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private OrdersService ordersService;

    @InjectMocks
    private OrdersController ordersController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ordersController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testPlaceOrderSuccess() throws Exception {
        Orders order = new Orders();
        order.setOrderId(1);

        doNothing().when(ordersService).addOrder(any(Orders.class));

        mockMvc.perform(post("/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(status().isCreated())
                .andExpect(content().string("Order Placed Successfully"));

        verify(ordersService, times(1)).addOrder(any(Orders.class));
    }

    @Test
    void testGetOrderById() throws Exception {
        Orders order = new Orders();
        order.setOrderId(1);

        when(ordersService.getOrderDetails(1)).thenReturn(order);

        mockMvc.perform(get("/api/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.orderId").value(1));

        verify(ordersService, times(1)).getOrderDetails(1);
    }

    @Test
    void testUpdateOrderStatus() throws Exception {
        doNothing().when(ordersService).updateOrderStatus(1, "Completed");

        mockMvc.perform(put("/api/1/Completed"))
                .andExpect(status().isOk())
                .andExpect(content().string("Order Updated sucessfully"));

        verify(ordersService, times(1)).updateOrderStatus(1, "Completed");
    }

    @Test
    void testCancelOrder() throws Exception {
        doNothing().when(ordersService).cancelOrder(1);

        mockMvc.perform(delete("/api/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Order deleted sucessfully"));

        verify(ordersService, times(1)).cancelOrder(1);
    }
}
