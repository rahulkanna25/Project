package com.model;
<<<<<<< HEAD
<<<<<<< HEAD

import jakarta.persistence.EmbeddedId;
=======
import jakarta.persistence.EmbeddedId;
 
>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
=======

import jakarta.persistence.EmbeddedId;
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
<<<<<<< HEAD
<<<<<<< HEAD

=======
 
>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
@Entity
@Table(name ="OrdersCoupons")
public class OrdersCoupons {
	
	@EmbeddedId
    private OrdersCouponsId id;
	
	
	@ManyToOne
	@MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders orders;
<<<<<<< HEAD
<<<<<<< HEAD

=======
 
>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    @ManyToOne
    @MapsId("couponId")
    @JoinColumn(name = "coupon_id")
    private Coupons coupons;
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

	public OrdersCouponsId getId() {
		return id;
	}

	public void setId(OrdersCouponsId id) {
		this.id = id;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Coupons getCoupons() {
		return coupons;
	}

	public void setCoupons(Coupons coupons) {
		this.coupons = coupons;
	}
<<<<<<< HEAD



}
=======
 
	public OrdersCouponsId getId() {
		return id;
	}
 
	public void setId(OrdersCouponsId id) {
		this.id = id;
	}
 
	public Orders getOrders() {
		return orders;
	}
 
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
 
	public Coupons getCoupons() {
		return coupons;
	}
 
	public void setCoupons(Coupons coupons) {
		this.coupons = coupons;
	}
 
 
 
}
>>>>>>> 8369f0426e4e1a499eb6177aaa8fdcb7ff2c5e53
=======
}
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
