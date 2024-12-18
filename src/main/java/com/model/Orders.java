package com.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;


    @Column(name = "order_status", length = 50)
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;

    @ManyToOne
    @JoinColumn(name = "delivery_drive_id")
    private DeliveryDrivers deliveryDriver;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItems> orderItems;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdersCoupons> ordersCoupons;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Ratings> ratings;

    public Orders() {
    }

    public Orders(Date orderDate, String orderStatus, Customers customer, Restaurants restaurant, DeliveryDrivers deliveryDriver) {
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.customer = customer;
        this.restaurant = restaurant;
        this.deliveryDriver = deliveryDriver;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
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
        return deliveryDriver;
    }

    public void setDeliveryDriver(DeliveryDrivers deliveryDriver) {
        this.deliveryDriver = deliveryDriver;
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
                ", deliveryDriver=" + deliveryDriver +
                '}';
    }
}
