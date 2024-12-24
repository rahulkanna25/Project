
package com.service;

import com.model.MenuItems;


import com.model.Restaurants;
<<<<<<< HEAD
=======
import com.DAO.MenuItemsDAO;
import com.DAO.RestaurantsDAO;
import com.exception.EmptyListException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DAO.MenuItemsDAO;
import com.DAO.RestaurantsDAO;
import com.exception.EmptyListException;
import com.exception.MenuItemNotFoundException;
import com.exception.RestaurantNotFoundException;


@Service
public class MenuItemsService {
 
    @Autowired
    private MenuItemsDAO menuItemsDAO;
 
    @Autowired
    private RestaurantsDAO restaurantsDAO;
 
    public List<MenuItems> getMenuItemsByRestaurant(int restaurantId) {
<<<<<<< HEAD

=======
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
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
<<<<<<< HEAD

        

=======
 
        
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
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
 
            throw new RestaurantNotFoundException("No Restaurant with Id"+restaurantId+ "found" );
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
        }
    }
 
   
<<<<<<< HEAD

=======
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
    public MenuItems getMenuItemById(int itemId) {
        Optional<MenuItems> menu = menuItemsDAO.findById(itemId);
        if(!menu.isPresent()) {
        	throw new MenuItemNotFoundException("No Item with ID "+ itemId+ " found");
        }
        return menu.get();
    }
   
   
    public MenuItems updateMenuItem(int itemId, MenuItems updatedMenuItem) {
<<<<<<< HEAD

=======
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
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
        }else {
<<<<<<< HEAD
            throw new MenuItemNotFoundException("Menu item not found"); 
        }
    }

}
=======
            throw new MenuItemNotFoundException("Menu item not found");
        }
    }
}
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
