package com.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "customer_email", nullable = false)
    private String customerEmail;

    @Column(name = "customer_phone", length = 20)
    private String customerPhone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Orders> orders;
    
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "customer_favorites",
        joinColumns = @JoinColumn(name = "customer_id"),
        inverseJoinColumns = @JoinColumn(name = "restaurant_id")
    )
    private List<Restaurants> favoriteRestaurants;

<<<<<<< HEAD
    
    public Customers() {
        super();
    }

    
    public Customers(int customerId, String customerName, String customerEmail, String customerPhone,
                     List<DeliveryAddress> deliveryAddresses, List<Orders> orders) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.deliveryAddresses = deliveryAddresses;
        this.orders = orders;
    }

    
    public int getCustomerId() {
=======
    public Customers() {}

    // Getters and Setters
    public Integer getCustomerId() {
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
    public List<Restaurants> getFavoriteRestaurants() {
        return favoriteRestaurants;
    }

    public void setFavoriteRestaurants(List<Restaurants> favoriteRestaurants) {
        this.favoriteRestaurants = favoriteRestaurants;
    }
}
