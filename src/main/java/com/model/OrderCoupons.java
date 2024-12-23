package com.model;
import jakarta.persistence.EmbeddedId;
 
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
 
@Entity
@Table(name ="OrdersCoupons")
public class OrdersCoupons {
	
	@EmbeddedId
    private OrdersCouponsId id;
	
	
	@ManyToOne
	@MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Orders orders;
 
    @ManyToOne
    @MapsId("couponId")
    @JoinColumn(name = "coupon_id")
    private Coupons coupons;
 
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
