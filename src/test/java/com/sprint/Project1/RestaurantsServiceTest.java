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

import com.DAO.DeliveryAddressDAO;
import com.DAO.MenuItemsDAO;
import com.DAO.RatingsDAO;
import com.DAO.RestaurantsDAO;
import com.exception.EmptyListException;
import com.exception.RestaurantNotFoundException;
import com.model.DeliveryAddress;
import com.model.MenuItems;
import com.model.Ratings;
import com.model.Restaurants;
import com.service.RestaurantsService;

public class RestaurantsServiceTest {

    @InjectMocks
    private RestaurantsService restaurantsService;

    @Mock
    private RestaurantsDAO restaurantsDAO;

    @Mock
    private DeliveryAddressDAO deliveryAddressDAO;

    @Mock
    private RatingsDAO ratingsDAO;

    @Mock
    private MenuItemsDAO menuItemsDAO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRestaurants_WhenRestaurantsExist() {
        List<Restaurants> restaurants = new ArrayList<>();
        restaurants.add(new Restaurants());

        when(restaurantsDAO.findAll()).thenReturn(restaurants);

        List<Restaurants> result = restaurantsService.getAllRestaurants();

        assertEquals(1, result.size());
        verify(restaurantsDAO, times(1)).findAll();
    }

    @Test
    public void testGetAllRestaurants_WhenNoRestaurantsExist() {
        when(restaurantsDAO.findAll()).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> restaurantsService.getAllRestaurants());
    }

    @Test
    public void testGetRestaurantById_WhenRestaurantExists() {
        Restaurants restaurant = new Restaurants();

        when(restaurantsDAO.findById(1)).thenReturn(Optional.of(restaurant));

        Restaurants result = restaurantsService.getRestaurantById(1);

        assertEquals(restaurant, result);
        verify(restaurantsDAO, times(1)).findById(1);
    }

    @Test
    public void testGetRestaurantById_WhenRestaurantDoesNotExist() {
        when(restaurantsDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> restaurantsService.getRestaurantById(1));
    }

    @Test
    public void testSaveRestaurant() {
        Restaurants restaurant = new Restaurants();

        restaurantsService.saveRestaurant(restaurant);

        verify(restaurantsDAO, times(1)).save(restaurant);
    }

    @Test
    public void testUpdateRestaurant_WhenRestaurantExists() {
        Restaurants existingRestaurant = new Restaurants();
        Restaurants updatedRestaurant = new Restaurants();
        updatedRestaurant.setRestaurantName("Updated Name");

        when(restaurantsDAO.findById(1)).thenReturn(Optional.of(existingRestaurant));

        restaurantsService.updateRestaurant(1, updatedRestaurant);

        verify(restaurantsDAO, times(1)).save(existingRestaurant);
        assertEquals("Updated Name", existingRestaurant.getRestaurantName());
    }

    @Test
    public void testUpdateRestaurant_WhenRestaurantDoesNotExist() {
        Restaurants updatedRestaurant = new Restaurants();

        when(restaurantsDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> restaurantsService.updateRestaurant(1, updatedRestaurant));
    }

    @Test
    public void testDeleteRestaurant_WhenRestaurantExists() {
        when(restaurantsDAO.existsById(1)).thenReturn(true);

        restaurantsService.deleteRestaurant(1);

        verify(restaurantsDAO, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteRestaurant_WhenRestaurantDoesNotExist() {
        when(restaurantsDAO.existsById(1)).thenReturn(false);

        assertThrows(RestaurantNotFoundException.class, () -> restaurantsService.deleteRestaurant(1));
    }

    @Test
    public void testGetMenu_WhenMenuItemsExist() {
        List<MenuItems> menuItems = new ArrayList<>();
        menuItems.add(new MenuItems());

        when(menuItemsDAO.findByRestaurant_RestaurantId(1)).thenReturn(menuItems);

        List<MenuItems> result = restaurantsService.getMenu(1);

        assertEquals(1, result.size());
        verify(menuItemsDAO, times(1)).findByRestaurant_RestaurantId(1);
    }

    @Test
    public void testGetMenu_WhenMenuItemsDoNotExist() {
        when(menuItemsDAO.findByRestaurant_RestaurantId(1)).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> restaurantsService.getMenu(1));
    }

    @Test
    public void testGetRatings_WhenRatingsExist() {
        List<Ratings> ratings = new ArrayList<>();
        ratings.add(new Ratings());

        when(ratingsDAO.findByRestaurant_restaurantId(1)).thenReturn(ratings);

        List<Ratings> result = restaurantsService.getRatings(1);

        assertEquals(1, result.size());
        verify(ratingsDAO, times(1)).findByRestaurant_restaurantId(1);
    }

    @Test
    public void testGetRatings_WhenNoRatingsExist() {
        when(ratingsDAO.findByRestaurant_restaurantId(1)).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> restaurantsService.getRatings(1));
    }

    @Test
    public void testGetAddresses_WhenAddressesExist() {
        List<DeliveryAddress> addresses = new ArrayList<>();
        addresses.add(new DeliveryAddress());

        when(deliveryAddressDAO.findAddressByRestaurantId(1)).thenReturn(addresses);

        List<DeliveryAddress> result = restaurantsService.getAddresses(1);

        assertEquals(1, result.size());
        verify(deliveryAddressDAO, times(1)).findAddressByRestaurantId(1);
    }

    @Test
    public void testGetAddresses_WhenNoAddressesExist() {
        when(deliveryAddressDAO.findAddressByRestaurantId(1)).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> restaurantsService.getAddresses(1));
    }
}

