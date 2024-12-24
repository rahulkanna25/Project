package com.DAO;

import com.model.CustomerFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerFavoriteDAO extends JpaRepository<CustomerFavorite, Integer> {
    List<CustomerFavorite> findByCustomerCustomerId(Integer customerId);
    void deleteByCustomerCustomerIdAndRestaurantRestaurantId(Integer customerId, Integer restaurantId);
}
