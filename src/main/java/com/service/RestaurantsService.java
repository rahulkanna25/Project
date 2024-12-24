package com.service;

import com.model.DeliveryAddress;


import com.model.MenuItems;
import com.model.Ratings;
import com.model.Restaurants;
import com.DAO.DeliveryAddressDAO;
import com.DAO.MenuItemsDAO;
import com.DAO.RatingsDAO;
import com.DAO.RestaurantsDAO;
import com.exception.EmptyListException;
import com.exception.RestaurantNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
 
@Service
public class RestaurantsService {
 
    @Autowired
    private RestaurantsDAO restaurantsDAO;
    

    
    @Autowired 
    private RatingsDAO ratingsDAO;
    
    
    @Autowired
    private DeliveryAddressDAO deliveryAddressDAO;
    
    @Autowired
    private MenuItemsDAO menuItemsDAO;
 

    public List<Restaurants> getAllRestaurants() {
        List<Restaurants> restaurantList = restaurantsDAO.findAll();
        if(restaurantList.isEmpty()) {
        	throw new EmptyListException("No Restaurants found");
        }
        return restaurantList;
    }
 
    public Restaurants getRestaurantById(int restaurantId) {
    	Optional<Restaurants> restaurant = restaurantsDAO.findById(restaurantId);
    	
    	if(!restaurant.isPresent()) {
    		throw new RestaurantNotFoundException("Restaurant with Id "+restaurantId+" not found" );
    	}
    	return restaurant.get();
    }
 
    public Restaurants createRestaurant(Restaurants restaurant) {
        return restaurantsDAO.save(restaurant);
    }
 
    public Restaurants updateRestaurant(int restaurantId, Restaurants updatedRestaurant) {
        if (restaurantsDAO.existsById(restaurantId)) {
            updatedRestaurant.setRestaurantId(restaurantId); 
            return restaurantsDAO.save(updatedRestaurant);
        } else {
            throw new RestaurantNotFoundException("Restaurant not found");
        }
    }
 
    public void deleteRestaurant(int restaurantId) {
        if (restaurantsDAO.existsById(restaurantId)) {
            restaurantsDAO.deleteById(restaurantId);
        } else {
            throw new RestaurantNotFoundException("Restaurant not found");
        }
    }
    
    public List<MenuItems> getMenu(int restaurantId){
		  List<MenuItems> menu = menuItemsDAO.findByRestaurant_RestaurantId(restaurantId);
		  
		  if(menu.isEmpty()) {

			  throw new EmptyListException("Menu Not available");

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
  			  throw new EmptyListException("No Address served");
  		  }
  		  return address;
  			   
  		   }
} 
