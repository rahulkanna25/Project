package com.service;

import com.model.Ratings;
import com.DAO.RatingsDAO; // Import your RatingsDAO
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingsService {

    @Autowired
    private RatingsDAO ratingsDAO; 

//    public List<Ratings> getReviewsByCustomer(int customerId) {
//    	 return ratingsDAO.findByOrder_Customer_CustomerId(customerId);    }
}
