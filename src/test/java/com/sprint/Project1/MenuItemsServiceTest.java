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

import com.DAO.MenuItemsDAO;
import com.DAO.RestaurantsDAO;
import com.exception.EmptyListException;
import com.exception.MenuItemNotFoundException;
import com.exception.RestaurantNotFoundException;
import com.model.MenuItems;
import com.model.Restaurants;
import com.service.MenuItemsService;

public class MenuItemsServiceTest {

    @InjectMocks
    private MenuItemsService menuItemsService;

    @Mock
    private MenuItemsDAO menuItemsDAO;

    @Mock
    private RestaurantsDAO restaurantsDAO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMenuItemsByRestaurant_WhenRestaurantExistsAndMenuItemsExist() {
        List<MenuItems> menuItems = new ArrayList<>();
        menuItems.add(new MenuItems());

        when(restaurantsDAO.findById(1)).thenReturn(Optional.of(new Restaurants()));
        when(menuItemsDAO.findByRestaurant_RestaurantId(1)).thenReturn(menuItems);

        List<MenuItems> result = menuItemsService.getMenuItemsByRestaurant(1);

        assertEquals(1, result.size());
        verify(menuItemsDAO, times(1)).findByRestaurant_RestaurantId(1);
    }

    @Test
    public void testGetMenuItemsByRestaurant_WhenRestaurantExistsAndMenuItemsDoNotExist() {
        when(restaurantsDAO.findById(1)).thenReturn(Optional.of(new Restaurants()));
        when(menuItemsDAO.findByRestaurant_RestaurantId(1)).thenReturn(new ArrayList<>());

        assertThrows(EmptyListException.class, () -> menuItemsService.getMenuItemsByRestaurant(1));
    }

    @Test
    public void testGetMenuItemsByRestaurant_WhenRestaurantDoesNotExist() {
        when(restaurantsDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> menuItemsService.getMenuItemsByRestaurant(1));
    }

    @Test
    public void testAddMenuItem_WhenRestaurantExists() {
        Restaurants restaurant = new Restaurants();
        MenuItems menuItem = new MenuItems();

        when(restaurantsDAO.findById(1)).thenReturn(Optional.of(restaurant));
        when(menuItemsDAO.save(menuItem)).thenReturn(menuItem);

        MenuItems result = menuItemsService.addMenuItem(1, menuItem);

        assertEquals(menuItem, result);
        verify(menuItemsDAO, times(1)).save(menuItem);
    }

    @Test
    public void testAddMenuItem_WhenRestaurantDoesNotExist() {
        MenuItems menuItem = new MenuItems();

        when(restaurantsDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(RestaurantNotFoundException.class, () -> menuItemsService.addMenuItem(1, menuItem));
    }

    @Test
    public void testGetMenuItemById_WhenMenuItemExists() {
        MenuItems menuItem = new MenuItems();

        when(menuItemsDAO.findById(1)).thenReturn(Optional.of(menuItem));

        MenuItems result = menuItemsService.getMenuItemById(1);

        assertEquals(menuItem, result);
        verify(menuItemsDAO, times(1)).findById(1);
    }

    @Test
    public void testGetMenuItemById_WhenMenuItemDoesNotExist() {
        when(menuItemsDAO.findById(1)).thenReturn(Optional.empty());

        assertThrows(MenuItemNotFoundException.class, () -> menuItemsService.getMenuItemById(1));
    }

    @Test
    public void testUpdateMenuItem_WhenMenuItemExists() {
        MenuItems updatedMenuItem = new MenuItems();
        updatedMenuItem.setMenuItemId(1);

        when(menuItemsDAO.existsById(1)).thenReturn(true);
        when(menuItemsDAO.save(updatedMenuItem)).thenReturn(updatedMenuItem);

        MenuItems result = menuItemsService.updateMenuItem(1, updatedMenuItem);

        assertEquals(updatedMenuItem, result);
        verify(menuItemsDAO, times(1)).save(updatedMenuItem);
    }

    @Test
    public void testUpdateMenuItem_WhenMenuItemDoesNotExist() {
        MenuItems updatedMenuItem = new MenuItems();

        when(menuItemsDAO.existsById(1)).thenReturn(false);

        assertThrows(MenuItemNotFoundException.class, () -> menuItemsService.updateMenuItem(1, updatedMenuItem));
    }

    @Test
    public void testDeleteMenuItem_WhenMenuItemExists() {
        when(menuItemsDAO.existsById(1)).thenReturn(true);

        menuItemsService.deleteMenuItem(1);

        verify(menuItemsDAO, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteMenuItem_WhenMenuItemDoesNotExist() {
        when(menuItemsDAO.existsById(1)).thenReturn(false);

        assertThrows(MenuItemNotFoundException.class, () -> menuItemsService.deleteMenuItem(1));
    }
}
