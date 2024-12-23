package com.service;

import com.model.MenuItems;
import com.model.Restaurants;
import com.DAO.MenuItemsDAO;
import com.DAO.RestaurantsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemsService {

    @Autowired
    private MenuItemsDAO menuItemsDAO;

    @Autowired
    private RestaurantsDAO restaurantsDAO; 

    public List<MenuItems> getMenuItemsByRestaurant(int restaurantId) {
        return menuItemsDAO.findByRestaurant_RestaurantId(restaurantId);
    }

    public MenuItems addMenuItem(int restaurantId, MenuItems menuItem) {
        Optional<Restaurants> restaurantOptional = restaurantsDAO.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            menuItem.setRestaurant(restaurantOptional.get()); 
            return menuItemsDAO.save(menuItem);
        } else {
            throw new RuntimeException("Restaurant not found"); 
        }
    }

   
    public Optional<MenuItems> getMenuItemById(int itemId) {
        return menuItemsDAO.findById(itemId);
    }

   
    public MenuItems updateMenuItem(int itemId, MenuItems updatedMenuItem) {
        if (menuItemsDAO.existsById(itemId)) {
            updatedMenuItem.setMenuItemId(itemId); 
            return menuItemsDAO.save(updatedMenuItem); 
        } else {
            throw new RuntimeException("Menu item not found");
        }
    }

    public void deleteMenuItem(int itemId) {
        if (menuItemsDAO.existsById(itemId)) {
            menuItemsDAO.deleteById(itemId); 
        } else {
            throw new RuntimeException("Menu item not found"); 
        }
    }
}
