package com.controller;

import com.DAO.OrdersDAO;
import com.model.DeliveryAddress;
import com.model.Restaurants;
<<<<<<< HEAD


=======
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
import com.service.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantsController {

    @Autowired
    private RestaurantsService restaurantsService;
    
    @Autowired
    private OrdersDAO orderDao;

    @GetMapping
    public ResponseEntity<List<Restaurants>> getAllRestaurants() {
        List<Restaurants> restaurants = restaurantsService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{restaurantId}")
    public ResponseEntity<Object> getRestaurantById(@PathVariable int restaurantId) {
        Optional<Restaurants> restaurant = restaurantsService.getRestaurantById(restaurantId);
        if (restaurant.isPresent()) {
            return ResponseEntity.ok(restaurant.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Restaurant not found\"}");
        }
    }

    @PostMapping
    public ResponseEntity<Restaurants> createRestaurant(@RequestBody Restaurants restaurant) {
        Restaurants newRestaurant = restaurantsService.createRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable int restaurantId, @RequestBody Restaurants updatedRestaurant) {
        try {
            Restaurants restaurant = restaurantsService.updateRestaurant(restaurantId, updatedRestaurant);
            return ResponseEntity.ok(restaurant);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"NOTFOUND\", \"message\": \"Restaurant not found\"}");
        }
    }

    @DeleteMapping("/{restaurantId}")
    public ResponseEntity<Object> deleteRestaurant(@PathVariable int restaurantId) {
<<<<<<< HEAD

      
        restaurantsService.deleteRestaurant(restaurantId);

        return ResponseEntity.ok("{\"code\": \"DELSUCCESS\", \"message\": \"Restaurant deleted successfully\"}");

    }
 
    @GetMapping("/{restaurantId}/menu")

    public ResponseEntity<Object> getMenuByRestaurant(@PathVariable int restaurantId) {
    	
    	

        return ResponseEntity.ok(restaurantsService.getMenu(restaurantId));

    }
 
    @GetMapping("/{restaurantId}/reviews")

    public ResponseEntity<Object> getReviewsByRestaurant(@PathVariable int restaurantId) {
    	
    	

        return ResponseEntity.ok(restaurantsService.getRatings(restaurantId));

    }
 
    @GetMapping("/{restaurantId}/delivery-areas")

    public ResponseEntity<Object> getDeliveryAreasByRestaurant(@PathVariable int restaurantId) {

        return ResponseEntity.ok(restaurantsService.getAddresses(restaurantId));

=======
        try {
            restaurantsService.deleteRestaurant(restaurantId);
            return ResponseEntity.ok("{\"code\": \"DELETESUCCESS\", \"message\": \"Restaurant deleted successfully\"}");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"code\": \"DELETEFAIL\", \"message\": \"" + e.getMessage() + "\"}");
        }
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
    }
  

}
