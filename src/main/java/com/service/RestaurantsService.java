package com.service;
 
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.DAO.RestaurantsDAO;
import com.model.Restaurants;
 
@Service
public class RestaurantsService {
 
    @Autowired
    private RestaurantsDAO restaurantsDAO;
 
    public List<Restaurants> getAllRestaurants() {
    	
        return restaurantsDAO.findAll();
    }
 
    public Restaurants getRestaurantById(int id) {
        return restaurantsDAO.findById(id).orElse(null);
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
        }
    }
 
    public void deleteRestaurant(int id) {
        restaurantsDAO.deleteById(id);
    }
}
