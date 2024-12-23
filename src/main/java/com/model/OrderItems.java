package com.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_item_id")
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private MenuItems menuItem;

    @Column(name = "quantity", nullable = false)
    private int quantity;

  

    public OrderItems() {}



	public int getOrderItemId() {
		return orderItemId;
	}



	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}



	public Orders getOrder() {
		return order;
	}



	public void setOrder(Orders order) {
		this.order = order;
	}



	public MenuItems getMenuItem() {
		return menuItem;
	}



	public void setMenuItem(MenuItems menuItem) {
		this.menuItem = menuItem;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}

