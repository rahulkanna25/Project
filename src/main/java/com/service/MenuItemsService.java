
package com.service;

import com.model.MenuItems;

import com.model.Restaurants;
import com.DAO.MenuItemsDAO;
import com.DAO.RestaurantsDAO;
import com.exception.EmptyListException;
import com.exception.MenuItemNotFoundException;
import com.exception.RestaurantNotFoundException;

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
    	Optional<Restaurants> restaurantOptional = restaurantsDAO.findById(restaurantId);
        if (!restaurantOptional.isPresent()) {
        	throw new RestaurantNotFoundException("No Restaurant with Id"+restaurantId+ "found" );
        }else {
        	
        	List<MenuItems> ml = menuItemsDAO.findByRestaurant_RestaurantId(restaurantId);
        	
        	if(ml.isEmpty()) {
        		throw new EmptyListException("Menu Not Available");
        	}
        	return ml;
        }
    }

    public MenuItems addMenuItem(int restaurantId, MenuItems menuItem) {
        Optional<Restaurants> restaurantOptional = restaurantsDAO.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            menuItem.setRestaurant(restaurantOptional.get()); 
            return menuItemsDAO.save(menuItem);
        } else {
            throw new RestaurantNotFoundException("No Restaurant with Id"+restaurantId+ "found" );
        }
    }

   
    public MenuItems getMenuItemById(int itemId) {
        Optional<MenuItems> menu = menuItemsDAO.findById(itemId);
        if(!menu.isPresent()) {
        	throw new MenuItemNotFoundException("No Item with ID "+ itemId+ " found");
        }
        return menu.get();
    }

   
    public MenuItems updateMenuItem(int itemId, MenuItems updatedMenuItem) {
        if (menuItemsDAO.existsById(itemId)) {
            updatedMenuItem.setMenuItemId(itemId); 
            return menuItemsDAO.save(updatedMenuItem); 
        } else {
            throw new MenuItemNotFoundException("Menu item not found");
        }
    }

    public void deleteMenuItem(int itemId) {
        if (menuItemsDAO.existsById(itemId)) {
            menuItemsDAO.deleteById(itemId); 
        } else {
            throw new MenuItemNotFoundException("Menu item not found"); 
        }
    }
}
