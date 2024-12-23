package com.sprint.Project1;
 
import com.controller.MenuItemsController;
import com.model.MenuItems;
import com.service.MenuItemsService;
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
 
public class MenuItemsControllerTest {
 
    @InjectMocks
    private MenuItemsController menuItemsController;
 
    @Mock
    private MenuItemsService menuItemsService;
 
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
 
    // Test: Get Menu Items by Restaurant ID
    @Test
    public void testGetMenuItemsByRestaurant() {
        int restaurantId = 1;
        List<MenuItems> mockMenuItems = Arrays.asList(
                new MenuItems(),
                new MenuItems()
        );
 
        when(menuItemsService.getMenuItemsByRestaurant(restaurantId)).thenReturn(mockMenuItems);
 
        ResponseEntity<List<MenuItems>> response = menuItemsController.getMenuItemsByRestaurant(restaurantId);
 
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockMenuItems, response.getBody());
        verify(menuItemsService, times(1)).getMenuItemsByRestaurant(restaurantId);
    }
 
    // Test: Add a New Menu Item
    @Test
    public void testAddMenuItem() {
        int restaurantId = 1;
        MenuItems newItem = new MenuItems();
        MenuItems savedItem = new MenuItems();
 
        when(menuItemsService.addMenuItem(restaurantId, newItem)).thenReturn(savedItem);
 
        ResponseEntity<MenuItems> response = menuItemsController.addMenuItem(restaurantId, newItem);
 
        assertEquals(201, response.getStatusCodeValue());
        assertEquals(savedItem, response.getBody());
        verify(menuItemsService, times(1)).addMenuItem(restaurantId, newItem);
    }
 
    // Test: Update a Menu Item
    @Test
    public void testUpdateMenuItemSuccess() {
        int restaurantId = 1;
        int menuItemId = 2;
        MenuItems updatedItem = new MenuItems();
 
        when(menuItemsService.updateMenuItem(menuItemId, updatedItem)).thenReturn(updatedItem);
 
        ResponseEntity<?> response = menuItemsController.updateMenuItem(restaurantId, menuItemId, updatedItem);
 
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(updatedItem, response.getBody());
        verify(menuItemsService, times(1)).updateMenuItem(menuItemId, updatedItem);
    }
 
    @Test
    public void testUpdateMenuItemNotFound() {
        int restaurantId = 1;
        int menuItemId = 999; // Non-existent item
        MenuItems updatedItem = new MenuItems();
 
        when(menuItemsService.updateMenuItem(menuItemId, updatedItem)).thenThrow(new RuntimeException("Menu item not found"));
 
        ResponseEntity<?> response = menuItemsController.updateMenuItem(restaurantId, menuItemId, updatedItem);
 
        assertEquals(404, response.getStatusCodeValue());
        assertEquals("{\"code\": \"NOTFOUND\", \"message\": \"Menu item not found\"}", response.getBody());
        verify(menuItemsService, times(1)).updateMenuItem(menuItemId, updatedItem);
    }
 
    // Test: Delete a Menu Item
    @Test
    public void testDeleteMenuItemSuccess() {
        int itemId = 3;
 
        doNothing().when(menuItemsService).deleteMenuItem(itemId);
 
        ResponseEntity<Object> response = menuItemsController.deleteMenuItem(itemId);
 
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("{\"code\": \"DELETESUCCESS\", \"message\": \"Menu item deleted successfully\"}", response.getBody());
        verify(menuItemsService, times(1)).deleteMenuItem(itemId);
    }
 
    @Test
    public void testDeleteMenuItemNotFound() {
        int itemId = 999; // Non-existent item
 
        doThrow(new RuntimeException("Item not found")).when(menuItemsService).deleteMenuItem(itemId);
 
        ResponseEntity<Object> response = menuItemsController.deleteMenuItem(itemId);
 
        assertEquals(404, response.getStatusCodeValue());
        assertEquals("{\"code\": \"DELETEFAIL\", \"message\": \"Item not found\"}", response.getBody());
        verify(menuItemsService, times(1)).deleteMenuItem(itemId);
    }
}
 
 