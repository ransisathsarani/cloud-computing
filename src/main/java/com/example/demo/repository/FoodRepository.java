package com.example.demo.repository;

import com.example.demo.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Integer>{
    @Query(value = "SELECT * FROM foods WHERE name = ?1", nativeQuery = true)
    List<Food> getFoodByName(String foodName);
}
