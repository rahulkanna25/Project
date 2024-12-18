package com.model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class OrdersCoupons implements Serializable {
    @Id
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Id
    @Column(name = "coupon_id", nullable = false)
    private int couponId;

    // No-argument constructor
    public OrdersCoupons() {
        super();
    }

    // All-argument constructor
    public OrdersCoupons(int orderId, int couponId) {
        this.orderId = orderId;
        this.couponId = couponId;
    }

    // Getters and Setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(couponId, orderId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        OrdersCoupons other = (OrdersCoupons) obj;
        return couponId == other.couponId && orderId == other.orderId;
    }

   // toString method
   @Override
   public String toString() {
       return "OrdersCoupons{" +
               "orderId=" + orderId +
               ", couponId=" + couponId +
               '}';
   }
}
