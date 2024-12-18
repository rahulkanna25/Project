package com.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.model.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "order_status", nullable = false, length = 50)
    private String orderStatus;

    /** Many-to-One: Customer */
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    /** Many-to-One: Restaurant */
    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;

    /** Many-to-One: DeliveryDriver */
    @ManyToOne
    @JoinColumn(name = "delivery_driver_id")
    private DeliveryDrivers deliveryDriver;

    /** One-to-Many: OrderItems */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;

    /** One-to-Many: Ratings */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Ratings> ratings;

    /** One-to-Many: OrdersCoupons */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrdersCoupons> ordersCoupons;
}
