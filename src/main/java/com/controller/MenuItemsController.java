package com.controller;

import com.model.MenuItems;
import com.service.MenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/menu/")
public class MenuItemsController {

    @Autowired
    private MenuItemsService menuItemsService;

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<List<MenuItems>> getMenuItemsByRestaurant(@PathVariable int restaurantId) {
        List<MenuItems> menuItems = menuItemsService.getMenuItemsByRestaurant(restaurantId);
        return ResponseEntity.ok(menuItems);
    }

    @PostMapping("/{restaurantId}/menu")
    public ResponseEntity<MenuItems> addMenuItem(@PathVariable int restaurantId, @RequestBody MenuItems menuItem) {
        MenuItems newMenuItem = menuItemsService.addMenuItem(restaurantId, menuItem);
        return new ResponseEntity<>(newMenuItem, HttpStatus.CREATED);
    }

    @PutMapping("/{restaurantId}/{menu_item_id}")
    public ResponseEntity<?> updateMenuItem(@PathVariable int restaurantId,@PathVariable int menu_item_id,
                                                  @RequestBody MenuItems updatedMenuItem) {
        try {
        	System.out.println("tried");
            MenuItems updatedItem = menuItemsService.updateMenuItem(menu_item_id, updatedMenuItem);
            return ResponseEntity.ok(updatedItem);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Menu item not found\"}");
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Object> deleteMenuItem(@PathVariable int itemId) {
        try {
            menuItemsService.deleteMenuItem(itemId);
            return ResponseEntity.ok("{\"code\": \"DELETESUCCESS\", \"message\": \"Menu item deleted successfully\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("{\"code\": \"DELETEFAIL\", \"message\": \"" + e.getMessage() + "\"}");
        }
    }

    }

