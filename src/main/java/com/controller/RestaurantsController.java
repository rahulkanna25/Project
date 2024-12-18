package com.controller;
 
import com.model.Restaurants;

import com.service.RestaurantsService;
 
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
 
import java.util.List;
 
@RestController

@RequestMapping("/api/restaurants")

public class RestaurantsController {
 
    @Autowired

    private RestaurantsService restaurantsService;
 
    @GetMapping

    public ResponseEntity<Object> getAllRestaurants() {

        List<Restaurants> restaurants = restaurantsService.getAllRestaurants();

        if (restaurants.isEmpty()) {

            return ResponseEntity.status(404).body("{\"code\": \"GETFAILS\", \"message\": \"No restaurants found\"}");

        }

        return ResponseEntity.ok(restaurants);

    }
 
    @GetMapping("/{restaurantId}")

    public ResponseEntity<Object> getRestaurantById(@PathVariable int restaurantId) {

        Restaurants restaurant = restaurantsService.getRestaurantById(restaurantId);

        if (restaurant == null) {

            return ResponseEntity.status(404).body("{\"code\": \"GETFAILS\", \"message\": \"Restaurant not found\"}");

        }

        return ResponseEntity.ok(restaurant);

    }
 
    @PostMapping

    public ResponseEntity<Object> createRestaurant(@RequestBody Restaurants restaurants) {

        restaurantsService.saveRestaurant(restaurants);

        return ResponseEntity.ok("{\"code\": \"POSTSUCCESS\", \"message\": \"Restaurant created successfully\"}");

    }
 
    @PutMapping("/{restaurantId}")

    public ResponseEntity<Object> updateRestaurant(@PathVariable int restaurantId, @RequestBody Restaurants restaurants) {

        if (restaurantsService.getRestaurantById(restaurantId) == null) {

            return ResponseEntity.status(404).body("{\"code\": \"UPDTFAILS\", \"message\": \"Restaurant not found\"}");

        }

        restaurantsService.updateRestaurant(restaurantId, restaurants);

        return ResponseEntity.ok("{\"code\": \"UPDATESUCCESS\", \"message\": \"Restaurant updated successfully\"}");

    }
 
    @DeleteMapping("/{restaurantId}")

    public ResponseEntity<Object> deleteRestaurant(@PathVariable int restaurantId) {

        if (restaurantsService.getRestaurantById(restaurantId) == null) {

            return ResponseEntity.status(404).body("{\"code\": \"DELFAILS\", \"message\": \"Restaurant not found\"}");

        }

        restaurantsService.deleteRestaurant(restaurantId);

        return ResponseEntity.ok("{\"code\": \"DELSUCCESS\", \"message\": \"Restaurant deleted successfully\"}");

    }
 
    @GetMapping("/{restaurantId}/menu")

    public ResponseEntity<Object> getMenuByRestaurant(@PathVariable Long restaurantId) {

        return ResponseEntity.ok("{\"message\": \"Menu items for restaurant retrieved successfully\"}");

    }
 
    @GetMapping("/{restaurantId}/reviews")

    public ResponseEntity<Object> getReviewsByRestaurant(@PathVariable int restaurantId) {

        return ResponseEntity.ok("{\"message\": \"Reviews for the restaurant retrieved successfully\"}");

    }
 
    @GetMapping("/{restaurantId}/delivery-areas")

    public ResponseEntity<Object> getDeliveryAreasByRestaurant(@PathVariable int restaurantId) {

        return ResponseEntity.ok("{\"message\": \"Delivery areas for the restaurant retrieved successfully\"}");

    }

}

 