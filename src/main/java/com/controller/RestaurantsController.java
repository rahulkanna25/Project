package com.controller;

import com.DAO.MenuItemsDAO;

import com.DAO.OrdersDAO;
import com.DAO.RatingsDAO;
import com.model.Restaurants;
import com.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {
 
    @Autowired
    private RestaurantsService restaurantsService;

    
    @Autowired
    private OrdersDAO orderDao;
    
    @Autowired
    private MenuItemsDAO menuItemsDAO;
    
    @Autowired
    private RatingsDAO ratingsDAO;

    @GetMapping
    public ResponseEntity<List<Restaurants>> getAllRestaurants() {
        List<Restaurants> restaurants = restaurantsService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }
 
    @GetMapping("/{restaurantId}")
    public ResponseEntity<?> getRestaurantById(@PathVariable int restaurantId) {
        Restaurants restaurant = restaurantsService.getRestaurantById(restaurantId);
        return new ResponseEntity<Restaurants>(restaurant,HttpStatus.OK);
    }
 
    @PostMapping
    public ResponseEntity<Restaurants> createRestaurant(@RequestBody Restaurants restaurant) {
        Restaurants newRestaurant = restaurantsService.createRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }
 
    @PutMapping("/{restaurantId}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable int restaurantId, @RequestBody Restaurants updatedRestaurant) {
       
            Restaurants restaurant = restaurantsService.updateRestaurant(restaurantId, updatedRestaurant);
            return ResponseEntity.ok(restaurant);
        
    }
 
    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Object> deleteRestaurant(@PathVariable int restaurantId) {
        
            restaurantsService.deleteRestaurant(restaurantId);
            return ResponseEntity.ok("Restaurant deleted successfully");
        
    }

    @GetMapping("/{restaurantId}/menu")
    public ResponseEntity<Object> getMenuByRestaurant(@PathVariable int restaurantId) {

        return ResponseEntity.ok(restaurantsService.getMenu(restaurantId));

    }
 
    @GetMapping("/{restaurantId}/reviews")
    public ResponseEntity<Object> getReviewsByRestaurant(@PathVariable int restaurantId) {
        return ResponseEntity.ok( restaurantsService.getRatings(restaurantId));

    }
 
    @GetMapping("/{restaurantId}/deliveryareas")
    public ResponseEntity<Object> getDeliveryAreasByRestaurant(@PathVariable int restaurantId) {
    	  

        return ResponseEntity.ok(restaurantsService.getAddresses(restaurantId));

    }

}

 

 
  


