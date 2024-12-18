package com.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ratings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {

    @Id
    @Column(name = "rating_id")
    private int ratingId;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "review", columnDefinition = "TEXT")
    private String review;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurants restaurants;
}
