package com.service;
<<<<<<< HEAD
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
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

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
<<<<<<< HEAD
import com.model.DeliveryAddress;
import com.model.MenuItems;
import com.model.Ratings;
import com.model.Restaurants;
 
=======
import com.exception.EmptyListException;
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
<<<<<<< HEAD

>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
=======
 
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
@Service
public class RestaurantsService {
 
    @Autowired
    private RestaurantsDAO restaurantsDAO;
<<<<<<< HEAD
<<<<<<< HEAD
    
<<<<<<< HEAD
    
    @Autowired
    private DeliveryAddressDAO deliveryAddressDAO; 
    
=======
    
    @Autowired
    private MenuItemsDAO menuItemsDAO;
>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
    
    @Autowired
=======

    
    @Autowired 
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    private RatingsDAO ratingsDAO;
    
    
    @Autowired
<<<<<<< HEAD
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
=======
    private DeliveryAddressDAO deliveryAddressDAO;
    
    @Autowired
    private MenuItemsDAO menuItemsDAO;
 

    public List<Restaurants> getAllRestaurants() {
        List<Restaurants> restaurantList = restaurantsDAO.findAll();
        if(restaurantList.isEmpty()) {
        	throw new EmptyListException("No Restaurants found");
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
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

<<<<<<< HEAD
<<<<<<< HEAD
 
=======
			  throw new EmptyListException("Menu Not available");

		  }
		  return menu;
			   
		   }

    
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    public List<Ratings> getRatings(int restaurantId){
  	  List<Ratings> Reviews = ratingsDAO.findByRestaurant_restaurantId(restaurantId);
  	  
  	  if(Reviews.isEmpty()) {
  		  throw new EmptyListException("No reviews available");
  	  }
  	  return Reviews;
  		   
  	   }
<<<<<<< HEAD
    
    
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


=======
     
     
     public List<DeliveryAddress> getAddresses(int restaurantId){
  		  List<DeliveryAddress> address = deliveryAddressDAO.findAddressByRestaurantId(restaurantId);
  		  
  		  if(address.isEmpty()) {
  			  throw new EmptyListException("No Address served");
  		  }
  		  return address;
  			   
  		   }
} 
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
