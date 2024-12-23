package com.model;

import java.io.Serializable;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class OrdersCouponsId implements Serializable {
    
   
    private int orderId;
    
    
    private int couponId;


 

    public OrdersCouponsId() {
        super();
    }

    
    public OrdersCouponsId(int orderId, int couponId) {
        this.orderId = orderId;
        this.couponId = couponId;
    }

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
        OrdersCouponsId other = (OrdersCouponsId) obj;
        return couponId == other.couponId && orderId == other.orderId;
    }

   @Override
   public String toString() {
       return "OrdersCoupons{" +
               "orderId=" + orderId +
               ", couponId=" + couponId +
               '}';
   }
}
