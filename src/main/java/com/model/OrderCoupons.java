package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ordercoupons")
public class OrderCoupons {

   

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order; 

    @ManyToOne
    @JoinColumn(name = "coupon_id", nullable = false)
    private Coupons coupon; 

    public OrderCoupons() {
    }

    // Getters and Setters


    

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Coupons getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupons coupon) {
        this.coupon = coupon;
    }
}
