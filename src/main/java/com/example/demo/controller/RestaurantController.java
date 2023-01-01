package com.example.demo.controller;

import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;
import com.example.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    //List
    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getRestaurants();

    }

    //Restaurant Search
    @GetMapping("/restaurant-search")
    public List<Restaurant> searchRestaurantByName(@RequestParam(name = "restaurantName") String restaurantName) {
        return restaurantService.getRestaurantByName(restaurantName);

    }

}
