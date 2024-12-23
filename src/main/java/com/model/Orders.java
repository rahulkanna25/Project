package com.model;

import java.time.LocalDate;
<<<<<<< HEAD
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

=======
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference; 
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date", nullable = false)
<<<<<<< HEAD
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;


    @Column(name = "order_status", length = 50)
    private String orderStatus;

    
=======
    private LocalDate orderDate;

    @Column(name = "order_status", length = 50)
    private String orderStatus;

>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
	@JsonBackReference // Prevent recursion during serialization
	private Restaurants restaurant;

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "driverid")
    private DeliveryDrivers deliveryDriver;
    
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customers customer;

    
    
    
    
    @Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus
				+ ", restaurant=" + restaurant + ", deliveryDrivers=" + deliveryDriver + ", customer=" + customer
				+ "]";
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



=======
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

>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public int getOrderId() {
		return orderId;
	}

<<<<<<< HEAD


=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

<<<<<<< HEAD


=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public LocalDate getOrderDate() {
		return orderDate;
	}

<<<<<<< HEAD


=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

<<<<<<< HEAD


=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public String getOrderStatus() {
		return orderStatus;
	}

<<<<<<< HEAD


=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

<<<<<<< HEAD


=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public Restaurants getRestaurant() {
		return restaurant;
	}

<<<<<<< HEAD


=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}

<<<<<<< HEAD


=======
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public DeliveryDrivers getDeliveryDriver() {
		return deliveryDriver;
	}

<<<<<<< HEAD


	public void setDeliveryDriver(DeliveryDrivers deliveryDrivers) {
		this.deliveryDriver = deliveryDrivers;
	}



=======
	public void setDeliveryDriver(DeliveryDrivers deliveryDriver) {
		this.deliveryDriver = deliveryDriver;
	}

>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
	public Customers getCustomer() {
		return customer;
	}

<<<<<<< HEAD


	public void setCustomer(Customers customer) {
		this.customer = customer;
	}



	



	public Orders() {
    }

}
=======
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
}
>>>>>>> c12262b9a5211b95b4081a588f65eec670f2bdbc
