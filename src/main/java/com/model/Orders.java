package com.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference; 
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "order_status", length = 50)
    private String orderStatus;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
	@JsonBackReference // Prevent recursion during serialization
	private Restaurants restaurant;

	@ManyToOne
	@JoinColumn(name = "driver_id")
	private DeliveryDrivers deliveryDriver;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customers customer;

	@ManyToOne
	@JoinColumn(name = "delivery_address_id")
	private DeliveryAddress deliveryAddress;
	
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Ratings> ratings;

	public Orders() {}

	public Orders(LocalDate orderDate, String orderStatus, Restaurants restaurant,
			DeliveryDrivers deliveryDriver, Customers customer) {
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.restaurant = restaurant;
		this.deliveryDriver = deliveryDriver;
		this.customer = customer;
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
}
