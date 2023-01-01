package com.example.demo.service;

import com.example.demo.model.Food;
import com.example.demo.model.Restaurant;
import com.example.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();

    }

    public List<Restaurant> getRestaurantByName(String restaurantName) {
        if(restaurantName != null) {
            return restaurantRepository.getRestaurantByName(restaurantName);
        } else {
            return restaurantRepository.findAll();
        }
    }
}
