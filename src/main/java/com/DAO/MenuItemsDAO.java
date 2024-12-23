package com.DAO;

import com.model.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemsDAO extends JpaRepository<MenuItems, Integer> {
    List<MenuItems> findByRestaurant_RestaurantId(int restaurantId);

}
