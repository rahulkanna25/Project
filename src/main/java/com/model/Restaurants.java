package com.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "restaurant_name", nullable = false)
    private String restaurantName;

    @Column(name = "restaurant_address", nullable = false)
    private String restaurantAddress;
    
    @Column(name="restaurant_phone", nullable=false)
    private String restaurantPhone;

<<<<<<< HEAD
<<<<<<< HEAD
   @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
   private List<MenuItems> menuItems;

=======
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<MenuItems> menuItems;
=======

   @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
   private List<MenuItems> menuItems;


    
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    
    
    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private DeliveryAddress deliveryAddress;
    
<<<<<<< HEAD
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Orders> orders;
    
    public Restaurants() {}

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


    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
