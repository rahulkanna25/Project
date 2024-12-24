package com.model;

import java.io.Serializable;

import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
<<<<<<< HEAD

=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

@Embeddable
public class OrdersCouponsId implements Serializable {
    
   
    private int orderId;
    
    
    private int couponId;

<<<<<<< HEAD
    
    public OrdersCouponsId() {
        super();
    }
=======

 

    public OrdersCouponsId() {
        super();
    }

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    
    public OrdersCouponsId(int orderId, int couponId) {
        this.orderId = orderId;
        this.couponId = couponId;
    }

<<<<<<< HEAD
    
    public int getOrderId() {
        return orderId;
    }
=======
    public int getOrderId() {
        return orderId;
    }

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

<<<<<<< HEAD
=======
 
    
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    @Override
    public int hashCode() {
        return Objects.hash(couponId, orderId);
    }

<<<<<<< HEAD


=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        OrdersCouponsId other = (OrdersCouponsId) obj;
        return couponId == other.couponId && orderId == other.orderId;
    }

<<<<<<< HEAD
   // toString method
=======
>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
   @Override
   public String toString() {
       return "OrdersCoupons{" +
               "orderId=" + orderId +
               ", couponId=" + couponId +
               '}';
   }
}
