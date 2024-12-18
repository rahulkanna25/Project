package com.service;

import com.model.Restaurants;
import com.model.MenuItems;
import com.model.Ratings;
import com.DAO.RestaurantsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantsService {

    @Autowired
    private RestaurantsDAO restaurantsDao;

    public List<Restaurants> getAllRestaurants() {
        return restaurantsDao.findAll();
    }

    public Optional<Restaurants> getRestaurantById(int restaurantId) {
        return restaurantsDao.findById(restaurantId);
    }

    public Restaurants createRestaurant(Restaurants restaurant) {
        return restaurantsDao.save(restaurant);
    }

    public Restaurants updateRestaurant(int restaurantId, Restaurants restaurantDetails) {
        return restaurantsDao.findById(restaurantId).map(existingRestaurant -> {
            existingRestaurant.setRestaurantName(restaurantDetails.getRestaurantName());
            existingRestaurant.setRestaurantAddress(restaurantDetails.getRestaurantAddress());
            existingRestaurant.setRestaurantPhone(restaurantDetails.getRestaurantPhone());
            return restaurantsDao.save(existingRestaurant);
        }).orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restaurantId));
    }

    public void deleteRestaurant(int restaurantId) {
        restaurantsDao.deleteById(restaurantId);
    }

    public List<MenuItems> getMenuByRestaurantId(int restaurantId) {
        return restaurantsDao.findById(restaurantId)
                .map(Restaurants::getMenuItems)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restaurantId));
    }

    public List<Ratings> getReviewsByRestaurantId(int restaurantId) {
        return restaurantsDao.findById(restaurantId)
                .map(Restaurants::getRatings)
                .orElseThrow(() -> new RuntimeException("Restaurant not found with ID: " + restaurantId));
    }

    public List<String> getDeliveryAreasByRestaurantId(int restaurantId) {
        return List.of("Area 1", "Area 2", "Area 3"); 
    }
}
