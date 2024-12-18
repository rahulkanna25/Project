package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orderitems")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {

    @Id
    @Column(name = "order_item_id")
    private int orderItemId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private MenuItems menuItems;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;
}
