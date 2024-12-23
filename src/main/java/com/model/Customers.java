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

    
    @ManyToMany
    @JoinTable(
        name = "customer_favorite_restaurant", 
        joinColumns = @JoinColumn(name = "customer_id"), 
        inverseJoinColumns = @JoinColumn(name = "restaurant_id") 
    )
    List<Restaurants> favouriteRestaurants;
    
    public Customers() {
        super();
    }

    
    public Customers(int customerId, String customerName, String customerEmail, String customerPhone,
                      List<Orders> orders) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        
        this.orders = orders;
    }

    
    
    // Getters and Setters
    public Integer getCustomerId() {

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

    public List<Restaurants> getFavouriteRestaurants() {
		return favouriteRestaurants;
	}


	public void setFavouriteRestaurants(List<Restaurants> favouriteRestaurants) {
		this.favouriteRestaurants = favouriteRestaurants;
	}


	public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
