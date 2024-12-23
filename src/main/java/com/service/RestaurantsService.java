package com.service;

import com.model.Restaurants;
import com.DAO.RestaurantsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantsService {

    @Autowired
    private RestaurantsDAO restaurantsDAO;

    public List<Restaurants> getAllRestaurants() {
        return restaurantsDAO.findAll();
    }

    public Optional<Restaurants> getRestaurantById(int restaurantId) {
        return restaurantsDAO.findById(restaurantId);
    }

    public Restaurants createRestaurant(Restaurants restaurant) {
        return restaurantsDAO.save(restaurant);
    }

    public Restaurants updateRestaurant(int restaurantId, Restaurants updatedRestaurant) {
        if (restaurantsDAO.existsById(restaurantId)) {
            updatedRestaurant.setRestaurantId(restaurantId); // Assuming you have a setRestaurantId method
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
    

}
