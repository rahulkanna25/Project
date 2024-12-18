package com.DAO;

import com.model.MenuItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuItemsDAO extends JpaRepository<MenuItems, Integer> {
    List<MenuItems> findByRestaurantId(int restaurantId);
}
