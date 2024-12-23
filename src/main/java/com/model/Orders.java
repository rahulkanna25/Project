package com.model;

import java.time.LocalDate;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference; 
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
	
	
	public Orders() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;


    @Column(name = "order_status", length = 50)
    private String orderStatus;


   @ManyToOne
   @JoinColumn(name = "restaurant_id", nullable = false)
	@JsonBackReference // Prevent recursion during serialization
	private Restaurants restaurant;


    @ManyToOne
    @JoinColumn(name = "driverid")
    private DeliveryDrivers deliveryDriver;
    
    @ManyToOne
    @JoinColumn(name = "customerid")
   private Customers customer;

    
    
    
    
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



	public Customers getCustomer() {
		return customer;
	}



	public void setCustomer(Customers customer) {
		this.customer = customer;
	}



	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", restaurant=" + restaurant + ", deliveryDrivers=" + deliveryDriver + ", customer=" + customer
				+ "]";
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



	public Orders(int orderId, LocalDate orderDate, String orderStatus, Restaurants restaurant,
			DeliveryDrivers deliveryDrivers, Customers customer) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.restaurant = restaurant;
		this.deliveryDriver = deliveryDrivers;
		this.customer = customer;
		
	}


}
