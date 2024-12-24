package com.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupons")
public class Coupons {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coupon_id")
    private int couponId;

    @Column(name = "coupon_code", nullable = false)
    private String couponCode;

    @Column(name = "discount_amount", nullable = false)
    private float discountAmount;

    @Column(name = "expiry_date", nullable = false)
    private Date expiryDate;

<<<<<<< HEAD
<<<<<<< HEAD
    @OneToMany(mappedBy = "coupons", cascade = CascadeType.ALL)
   private List<OrdersCoupons> ordersCoupons;
=======
=======

    @OneToMany(mappedBy = "coupons", cascade = CascadeType.ALL)
   private List<OrdersCoupons> ordersCoupons;

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    public Coupons() {}

    public Coupons(int couponId, String couponCode, float discountAmount, Date expiryDate) {
        this.couponId = couponId;
        this.couponCode = couponCode;
        this.discountAmount = discountAmount;
        this.expiryDate = expiryDate;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
<<<<<<< HEAD
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
}
