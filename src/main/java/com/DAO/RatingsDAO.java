package com.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Ratings;

@Repository
public interface RatingsDAO extends JpaRepository<Ratings, Integer>{

}
