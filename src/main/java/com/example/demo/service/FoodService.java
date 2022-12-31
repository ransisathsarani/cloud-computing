package com.example.demo.service;

import com.example.demo.model.Food;
import com.example.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    public Food saveFood(Food food) {
        return foodRepository.save(food);
    }

    public Food getFood(int foodId) {
        return foodRepository.findById(foodId).orElseThrow(() ->new RuntimeException("not found"));
    }

    public List<Food> getFoods() {
        return foodRepository.findAll();

    }

    public Food updateFood(int foodId, Food food) {
        Food existingFood = foodRepository.findById(foodId).orElseThrow(() -> new RuntimeException("not found"));
        existingFood.setName(food.getName());
        existingFood.setPrice(food.getPrice());
        foodRepository.save(existingFood);
        return existingFood;

    }

    public Food deleteFood(int foodId) {
        Food existingFood = foodRepository.findById(foodId).orElseThrow(() -> new RuntimeException("not found"));
        foodRepository.deleteById(foodId);
        return existingFood;
    }

    public List<Food> getFoodByName(String foodName) {
        return foodRepository.getFoodByName(foodName);
    }


}
