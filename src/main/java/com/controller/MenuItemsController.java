package com.controller;

import com.model.MenuItems;
import com.model.Restaurants;
import com.service.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.model.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/menu")
public class MenuItemsController {

    @Autowired
    private MenuItemsService menuItemsService;

    @GetMapping
    public ResponseEntity<List<MenuItems>> getAllMenuItems(@PathVariable int restaurantId) {
        List<MenuItems> menuItems = menuItemsService.getAllMenuItemsByRestaurant(restaurantId);
        return ResponseEntity.ok(menuItems);
    }

    @PostMapping
    public ResponseEntity<MenuItems> addMenuItem(@PathVariable int restaurantId,String restaurantName,String restaurantAddress,String restaurantPhone, @RequestBody MenuItems menuItem) {
        menuItem.setRestaurant(new Restaurants(restaurantId, restaurantName, restaurantAddress, restaurantPhone)); 
        MenuItems newMenuItem = menuItemsService.addMenuItem(menuItem);
        return new ResponseEntity<>(newMenuItem, HttpStatus.CREATED);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Object> getMenuItemById(@PathVariable int restaurantId, @PathVariable int itemId) {
        Optional<MenuItems> menuItem = menuItemsService.getMenuItemById(itemId);
        if (menuItem.isPresent()) {
            return ResponseEntity.ok(menuItem.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Menu item not found\"}");
        }
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Object> updateMenuItem(@PathVariable int restaurantId,String restaurantName,String restaurantAddress,String restaurantPhone, @PathVariable int itemId,
                                                  @RequestBody MenuItems updatedMenuItem) {
        Optional<MenuItems> existingMenuItem = menuItemsService.getMenuItemById(itemId);
        if (existingMenuItem.isPresent()) {
            updatedMenuItem.setRestaurant(new Restaurants(restaurantId,restaurantName, restaurantAddress, restaurantPhone )); // Set the restaurant ID if needed
            updatedMenuItem.setId(itemId); 
            MenuItems updatedItem = menuItemsService.updateMenuItem(updatedMenuItem);
            return ResponseEntity.ok(updatedItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Menu item not found\"}");
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Object> deleteMenuItem(@PathVariable int restaurantId, @PathVariable int itemId) {
        try {
            menuItemsService.deleteMenuItem(itemId);
            return ResponseEntity.ok("{\"code\": \"DELETESUCCESS\", \"message\": \"Menu item deleted successfully\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"DELETEFAIL\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }
}
