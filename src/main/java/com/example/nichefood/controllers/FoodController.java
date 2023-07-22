package com.example.nichefood.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/food")
public class FoodController {

    @GetMapping("foods")
    public String getFoodItems() {
        return "All foods";
    }

    @GetMapping("foodsById")
    public String getFoodItemById() {
        return "Food by id";
    }

    @GetMapping("foodsByHotelId")
    public String getFoodItemByHotelId() {
        return "Food by hotel id";
    }

    @GetMapping("foodsByCuisine")
    public String getFoodItemByCuisine() {
        return "Food by cuisine";
    }

    @GetMapping("foodsByAvailability")
    public String getFoodItemByAvailability() {
        return "Food by availability";
    }

    @PostMapping("addFood")
    public String addFoodItem() {
        return "Food added";
    }

    @PatchMapping("updateFood")
    public String updateFoodItem() {
        return "Food updated";
    }

    @DeleteMapping("deleteFood")
    public String deleteFoodItem() {
        return "Food deleted";
    }
}
