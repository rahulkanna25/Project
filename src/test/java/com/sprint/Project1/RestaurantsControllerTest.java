package com.sprint.Project1;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.model.Restaurants;
import com.service.RestaurantsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.controller.RestaurantsController;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.List;

class RestaurantsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private RestaurantsService restaurantsService;

    @InjectMocks
    private RestaurantsController restaurantsController;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(restaurantsController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testGetAllRestaurants() throws Exception {
        List<Restaurants> restaurants = Collections.singletonList(new Restaurants());

        when(restaurantsService.getAllRestaurants()).thenReturn(restaurants);

        mockMvc.perform(get("/api/restaurants"))
                .andExpect(status().isOk());

        verify(restaurantsService, times(1)).getAllRestaurants();
    }

    @Test
    void testGetRestaurantById() throws Exception {
        Restaurants restaurant = new Restaurants();

        when(restaurantsService.getRestaurantById(1)).thenReturn(restaurant);

        mockMvc.perform(get("/api/restaurants/1"))
                .andExpect(status().isOk());

        verify(restaurantsService, times(1)).getRestaurantById(1);
    }

    @Test
    void testCreateRestaurant() throws Exception {
        Restaurants restaurant = new Restaurants();

        doNothing().when(restaurantsService).saveRestaurant(any(Restaurants.class));

        mockMvc.perform(post("/api/restaurants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(restaurant)))
                .andExpect(status().isOk());

        verify(restaurantsService, times(1)).saveRestaurant(any(Restaurants.class));
    }

    @Test
    void testUpdateRestaurant() throws Exception {
        Restaurants restaurant = new Restaurants();

        when(restaurantsService.getRestaurantById(1)).thenReturn(restaurant);
        doNothing().when(restaurantsService).updateRestaurant(eq(1), any(Restaurants.class));

        mockMvc.perform(put("/api/restaurants/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(restaurant)))
                .andExpect(status().isOk());

        verify(restaurantsService, times(1)).updateRestaurant(eq(1), any(Restaurants.class));
    }

    @Test
    void testDeleteRestaurant() throws Exception {
        doNothing().when(restaurantsService).deleteRestaurant(1);

        mockMvc.perform(delete("/api/restaurants/1"))
                .andExpect(status().isOk());

        verify(restaurantsService, times(1)).deleteRestaurant(1);
    }

    @Test
    void testGetMenuByRestaurant() throws Exception {
        doNothing().when(restaurantsService).getMenu(1);

        mockMvc.perform(get("/api/restaurants/1/menu"))
                .andExpect(status().isOk());

        verify(restaurantsService, times(1)).getMenu(1);
    }

    @Test
    void testGetReviewsByRestaurant() throws Exception {
        when(restaurantsService.getRatings(1)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/restaurants/1/reviews"))
                .andExpect(status().isOk());

        verify(restaurantsService, times(1)).getRatings(1);
    }

    @Test
    void testGetDeliveryAreasByRestaurant() throws Exception {
        when(restaurantsService.getAddresses(1)).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/restaurants/1/delivery-areas"))
                .andExpect(status().isOk());

        verify(restaurantsService, times(1)).getAddresses(1);
    }
}

