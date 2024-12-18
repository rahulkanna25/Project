package com.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;


    @Column(name = "order_status", length = 50)
    private String orderStatus;

    
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;
    
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "driverid")
    private DeliveryDrivers deliveryDrivers;
    
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> orderItems;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdersCoupons> ordersCoupons;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Ratings> ratings;

    public Orders() {
    }

    public Orders(LocalDate orderDate, String orderStatus, Customers customer, Restaurants restaurant, DeliveryDrivers deliveryDriver) {
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.customer = customer;
        this.restaurant = restaurant;
        this.deliveryDrivers = deliveryDriver;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public DeliveryDrivers getDeliveryDriver() {
        return deliveryDrivers;
    }

    public void setDeliveryDriver(DeliveryDrivers deliveryDriver) {
        this.deliveryDrivers = deliveryDriver;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrdersCoupons> getOrdersCoupons() {
        return ordersCoupons;
    }

    public void setOrdersCoupons(List<OrdersCoupons> ordersCoupons) {
        this.ordersCoupons = ordersCoupons;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", deliveryDriver=" + deliveryDrivers +
                '}';
    }
}