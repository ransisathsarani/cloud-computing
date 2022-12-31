package com.example.demo.controller;

import com.example.demo.model.Food;
import com.example.demo.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    //insert
    @PostMapping("/food")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food savedFood = foodService.saveFood(food);
        return new ResponseEntity<>(savedFood, HttpStatus.CREATED);
    }

    //find by id
    @GetMapping("/food")
    public ResponseEntity<Food> findFoodById(@RequestParam(name = "foodId") int foodId) {
        Food food = foodService.getFood(foodId);
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    //List
    @GetMapping("/foods")
    public List<Food> getAllFoods() {
        return foodService.getFoods();
    }

    //Update
    @PatchMapping("/food")
    public ResponseEntity<Food> updateFood(@RequestParam(name = "foodId") int foodId, @RequestBody Food food) {
        Food updatedFood = foodService.updateFood(foodId, food);
        return new ResponseEntity<>(updatedFood, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/food")
    public ResponseEntity<Food> deleteFood(@RequestParam(name = "foodId") int foodId){
        Food deletedFood = foodService.deleteFood(foodId);
        return new ResponseEntity<>(deletedFood, HttpStatus.OK);
    }

    //get food by name using a raw SQL statement
    @GetMapping("/food-by-name")
    public List<Food> getFoodByName(@RequestParam(name = "foodName") String foodName) {
        return foodService.getFoodByName(foodName);

    }





}
