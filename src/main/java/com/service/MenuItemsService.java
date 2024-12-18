package com.service;

import com.model.MenuItems;
import com.DAO.MenuItemsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemsService {

    @Autowired
    private MenuItemsDAO menuItemsDAO;

    public List<MenuItems> getAllMenuItemsByRestaurant(int restaurantId) {
        return menuItemsDAO.findByRestaurantId(restaurantId);
    }

    public MenuItems addMenuItem(MenuItems menuItem) {
        return menuItemsDAO.save(menuItem);
    }

    public Optional<MenuItems> getMenuItemById(int itemId) {
        return menuItemsDAO.findById(itemId);
    }

    public MenuItems updateMenuItem(MenuItems menuItem) {
        return menuItemsDAO.save(menuItem);
    }

    public void deleteMenuItem(int itemId) {
        if (menuItemsDAO.existsById(itemId)) {
            menuItemsDAO.deleteById(itemId);
        } else {
            throw new RuntimeException("Menu item not found");
        }
    }
}
