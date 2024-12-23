package com.service;
 
import java.util.List;
import java.util.Optional;
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
 
@Service
public class RestaurantsService {
 
    @Autowired
    private RestaurantsDAO restaurantsDAO;
    
    
    @Autowired
    private DeliveryAddressDAO deliveryAddressDAO; 
    
    
    @Autowired
    private RatingsDAO ratingsDAO;
    
    @Autowired
    MenuItemsDAO menuItemsDAO;
 
    public List<Restaurants> getAllRestaurants() {
    	
    	List<Restaurants> rl = restaurantsDAO.findAll();
    	
    	if(rl.isEmpty()) {
    		throw new EmptyListException("No Restaurants Available");
    		
    	}
    	return rl;
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
	   
 
}
