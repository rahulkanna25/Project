package com.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "menu_items")
public class MenuItems {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
<<<<<<< HEAD
<<<<<<< HEAD
    @Column(name = "menu_item_id")
=======
    @Column(name = "item_id")
>>>>>>> fcd70ba35319110343160b3229f52423c9f2d447
=======

    

    @Column(name = "item_id")

>>>>>>> 9f560c4236d70c1b04558ab1137b582cfefb24b6
    private int menuItemId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurant;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "item_price", nullable = false)
    private BigDecimal itemPrice;
    
	@Column(name="item_description", columnDefinition="TEXT")
	private String itemDescription;

    public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public MenuItems() {}

    public int getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }

    public Restaurants getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurants restaurant) {
        this.restaurant = restaurant;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }
}
