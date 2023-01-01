package com.example.demo.repository;

import com.example.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query(value = "SELECT * FROM restaurants WHERE name LIKE ?1%", nativeQuery = true)
    List<Restaurant> getRestaurantByName(String restaurantName);
}
