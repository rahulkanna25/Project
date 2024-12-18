package com.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurants")
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "restaurant_name", nullable = false, length = 255)
    private String restaurantName;

    @Column(name = "restaurant_address", nullable = false, length = 255)
    private String restaurantAddress;

    @Column(name = "restaurant_phone", length = 20)
    private String restaurantPhone;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<MenuItems> menuItems;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Ratings> ratings;

    // Default Constructor
    public Restaurants() {
    }

    // Parameterized Constructor
    public Restaurants(int restaurantId, String restaurantName, String restaurantAddress, String restaurantPhone) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantPhone = restaurantPhone;
    }

    // Getters and Setters
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public List<MenuItems> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItems> menuItems) {
        this.menuItems = menuItems;
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }

    // toString Method
    @Override
    public String toString() {
        return "Restaurants{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddress='" + restaurantAddress + '\'' +
                ", restaurantPhone='" + restaurantPhone + '\'' +
                '}';
    }
}
