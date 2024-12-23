package com.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coupons {

    @Id
    @Column(name = "coupon_id")
    private int couponId;

    @Column(name = "coupon_code", nullable = false)
    private String couponCode;

    @Column(name = "discount_amount", nullable = false)
    private float discountAmount;

    @Column(name = "expiry_date", nullable = false)
    private Date expiryDate;

    @OneToMany(mappedBy = "coupons", cascade = CascadeType.ALL)
   private List<OrdersCoupons> ordersCoupons;
}
