package com.service;
<<<<<<< HEAD
 
import java.util.List;
import java.util.Optional;
=======

import com.model.MenuItems;
import com.model.Ratings;
import com.model.Restaurants;
import com.DAO.DeliveryAddressDAO;
import com.DAO.MenuItemsDAO;
import com.DAO.RatingsDAO;
import com.DAO.RestaurantsDAO;
<<<<<<< HEAD
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
 
=======
import com.exception.EmptyListException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.model.*;
import java.util.List;
import java.util.Optional;

>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
@Service
public class RestaurantsService {
 
    @Autowired
    private RestaurantsDAO restaurantsDAO;
<<<<<<< HEAD
<<<<<<< HEAD
    
    
    @Autowired
    private DeliveryAddressDAO deliveryAddressDAO; 
    
=======
    
    @Autowired
    private MenuItemsDAO menuItemsDAO;
>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
    
    @Autowired
    private RatingsDAO ratingsDAO;
    
    @Autowired
<<<<<<< HEAD
    MenuItemsDAO menuItemsDAO;
 
    public List<Restaurants> getAllRestaurants() {
    	
    	List<Restaurants> rl = restaurantsDAO.findAll();
    	
    	if(rl.isEmpty()) {
    		throw new EmptyListException("No Restaurants Available");
    		
    	}
    	return rl;
=======
=======
    private DeliveryAddressDAO deliveryAddressDAO;
>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53

    public List<Restaurants> getAllRestaurants() {
        return restaurantsDAO.findAll();
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
    }
 
    public Restaurants getRestaurantById(int id) {
        Optional<Restaurants> restaurant =restaurantsDAO.findById(id);
        if(!restaurant.isPresent()) {
        	throw new RestaurantNotFoundException("No Restaurant with Id "+id+ " found" );
        }
        return restaurant.get() ;
    }
 
    public void saveRestaurant(Restaurants restaurant) {
        restaurantsDAO.save(restaurant);
    }
 
    public void updateRestaurant(int id, Restaurants restaurant) {
        Optional<Restaurants> existingRestaurant = restaurantsDAO.findById(id);
        if (existingRestaurant.isPresent()) {
            Restaurants updatedRestaurant = existingRestaurant.get();
            updatedRestaurant.setRestaurantName(restaurant.getRestaurantName());
            updatedRestaurant.setRestaurantAddress(restaurant.getRestaurantAddress());
            updatedRestaurant.setRestaurantPhone(restaurant.getRestaurantPhone());
            restaurantsDAO.save(updatedRestaurant);
        }else {
        	throw new RestaurantNotFoundException("No Restaurant with Id "+id+ " found" );
        }
    }
    public void deleteRestaurant(int id) {
    	if(restaurantsDAO.existsById(id)) {
        restaurantsDAO.deleteById(id);
    }else {
    	
    	throw new RestaurantNotFoundException("No Restaurant with Id "+id+ " found" );
    	
    }
    }
    
    public List<MenuItems> getMenu(int restaurantId){
    	  List<MenuItems> Menu = menuItemsDAO.findByRestaurant_RestaurantId(restaurantId);
    	  
    	  if(Menu.isEmpty()) {
    		  throw new EmptyListException("Menu is not available");
    	  }
    	  return Menu;
    		   
    	   }

<<<<<<< HEAD
 
    public List<Ratings> getRatings(int restaurantId){
  	  List<Ratings> Reviews = ratingsDAO.findByRestaurant_restaurantId(restaurantId);
  	  
  	  if(Reviews.isEmpty()) {
  		  throw new EmptyListException("No reviews available");
  	  }
  	  return Reviews;
  		   
  	   }
    
    
    public List<DeliveryAddress> getAddresses(int restaurantId){
		  List<DeliveryAddress> address = deliveryAddressDAO.findAddressByRestaurantId(restaurantId);
		  
		  if(address.isEmpty()) {
			  throw new EmptyListException("No addresses served");
		  }
		  return address;
			   
		   }
	   
 
=======
    public Optional<Restaurants> getRestaurantById(int restaurantId) {
        return restaurantsDAO.findById(restaurantId);
    }

    public Restaurants createRestaurant(Restaurants restaurant) {
        return restaurantsDAO.save(restaurant);
    }

    public Restaurants updateRestaurant(int restaurantId, Restaurants updatedRestaurant) {
        if (restaurantsDAO.existsById(restaurantId)) {
            updatedRestaurant.setRestaurantId(restaurantId); 
            return restaurantsDAO.save(updatedRestaurant);
        } else {
            throw new RuntimeException("Restaurant not found");
        }
    }

    public void deleteRestaurant(int restaurantId) {
        if (restaurantsDAO.existsById(restaurantId)) {
            restaurantsDAO.deleteById(restaurantId);
        } else {
            throw new RuntimeException("Restaurant not found");
        }
    }
    @Autowired
    private RestaurantsDAO restaurantRepository;

    public Restaurants findById(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }
    
    public List<MenuItems> getMenu(int restaurantId){
		  List<MenuItems> menu = menuItemsDAO.findByRestaurant_RestaurantId(restaurantId);
		  
		  if(menu.isEmpty()) {
			  throw new EmptyListException("No reviews available");
		  }
		  return menu;
			   
		   }
  
  public List<Ratings> getRatings(int restaurantId){
	  List<Ratings> Reviews = ratingsDAO.findByRestaurant_restaurantId(restaurantId);
	  
	  if(Reviews.isEmpty()) {
		  throw new EmptyListException("No reviews available");
	  }
	  return Reviews;
		   
	   }
   
   
   public List<DeliveryAddress> getAddresses(int restaurantId){
		  List<DeliveryAddress> address = deliveryAddressDAO.findAddressByRestaurantId(restaurantId);
		  
		  if(address.isEmpty()) {
			  throw new EmptyListException("No reviews available");
		  }
		  return address;
			   
		   }
	   


>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
}


