
package com.service;

import com.model.MenuItems;
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

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

<<<<<<< HEAD
=======
import com.model.Restaurants;
import com.DAO.MenuItemsDAO;
import com.DAO.RestaurantsDAO;
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

@Service
public class MenuItemsService {
 
    @Autowired
    private MenuItemsDAO menuItemsDAO;
 
    @Autowired
    private RestaurantsDAO restaurantsDAO;
 
    public List<MenuItems> getMenuItemsByRestaurant(int restaurantId) {
<<<<<<< HEAD
<<<<<<< HEAD
=======

=======
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
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
        return menuItemsDAO.findByRestaurant_RestaurantId(restaurantId);
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
    }
=======
<<<<<<< HEAD
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

        

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
<<<<<<< HEAD
            throw new RestaurantNotFoundException("No Restaurant with Id"+restaurantId+ "found" );
=======
            throw new RuntimeException("Restaurant not found"); 
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======

            throw new RestaurantNotFoundException("No Restaurant with Id"+restaurantId+ "found" );

=======
 
            throw new RestaurantNotFoundException("No Restaurant with Id"+restaurantId+ "found" );
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
        }
    }
 
   
<<<<<<< HEAD
<<<<<<< HEAD
=======

=======
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    public MenuItems getMenuItemById(int itemId) {
        Optional<MenuItems> menu = menuItemsDAO.findById(itemId);
        if(!menu.isPresent()) {
        	throw new MenuItemNotFoundException("No Item with ID "+ itemId+ " found");
        }
        return menu.get();
<<<<<<< HEAD
=======
    public Optional<MenuItems> getMenuItemById(int itemId) {
        return menuItemsDAO.findById(itemId);
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    }
   
   
    public MenuItems updateMenuItem(int itemId, MenuItems updatedMenuItem) {
<<<<<<< HEAD
<<<<<<< HEAD
=======

=======
 
>>>>>>> d33503d368364d1afcb7689016069e81f28e8ae1
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
        if (menuItemsDAO.existsById(itemId)) {
            updatedMenuItem.setMenuItemId(itemId);
            return menuItemsDAO.save(updatedMenuItem);
        } else {
            throw new MenuItemNotFoundException("Menu item not found");
        }
    }
 
    public void deleteMenuItem(int itemId) {
        if (menuItemsDAO.existsById(itemId)) {
<<<<<<< HEAD
            menuItemsDAO.deleteById(itemId); 
=======
        if (menuItemsDAO.existsById(itemId)) {
            updatedMenuItem.setMenuItemId(itemId); 
            return menuItemsDAO.save(updatedMenuItem); 
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
        } else {
=======
            menuItemsDAO.deleteById(itemId);
        }else {
<<<<<<< HEAD
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
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
