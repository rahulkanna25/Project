package com.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersCoupons implements Serializable {

    @Column(name = "order_id", nullable = false)
    private int orderId;

    @Column(name = "coupon_id", nullable = false)
    private int couponId;

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
}
