
package com.service;

import com.model.MenuItems;
<<<<<<< HEAD

import com.model.Restaurants;
import com.DAO.MenuItemsDAO;
import com.DAO.RestaurantsDAO;
import com.exception.EmptyListException;
import com.exception.MenuItemNotFoundException;
import com.exception.RestaurantNotFoundException;

=======
import com.model.Restaurants;
import com.DAO.MenuItemsDAO;
import com.DAO.RestaurantsDAO;
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
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
<<<<<<< HEAD
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
=======
        return menuItemsDAO.findByRestaurant_RestaurantId(restaurantId);
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
    }

    public MenuItems addMenuItem(int restaurantId, MenuItems menuItem) {
        Optional<Restaurants> restaurantOptional = restaurantsDAO.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            menuItem.setRestaurant(restaurantOptional.get()); 
            return menuItemsDAO.save(menuItem);
        } else {
<<<<<<< HEAD
            throw new RestaurantNotFoundException("No Restaurant with Id"+restaurantId+ "found" );
=======
            throw new RuntimeException("Restaurant not found"); 
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
        }
    }

   
<<<<<<< HEAD
    public MenuItems getMenuItemById(int itemId) {
        Optional<MenuItems> menu = menuItemsDAO.findById(itemId);
        if(!menu.isPresent()) {
        	throw new MenuItemNotFoundException("No Item with ID "+ itemId+ " found");
        }
        return menu.get();
=======
    public Optional<MenuItems> getMenuItemById(int itemId) {
        return menuItemsDAO.findById(itemId);
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
    }

   
    public MenuItems updateMenuItem(int itemId, MenuItems updatedMenuItem) {
<<<<<<< HEAD
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
=======
        if (menuItemsDAO.existsById(itemId)) {
            updatedMenuItem.setMenuItemId(itemId); 
            return menuItemsDAO.save(updatedMenuItem); 
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
        } else {
            throw new MenuItemNotFoundException("Menu item not found"); 
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
