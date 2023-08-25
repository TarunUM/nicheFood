package com.example.nichefood.controllers;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.food.FoodRequest;
import com.example.nichefood.models.Food;
import com.example.nichefood.services.FoodServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/food")
public class FoodController {
    private final FoodServices foodServices;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Food>>> getFoodItems() {
        return ResponseEntity.ok(foodServices.getFoodItems());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ApiResponse<Food>> getFoodItemById(@PathVariable("id") String id) {
        return ResponseEntity.ok(foodServices.getFoodItemById(id));
    }

    @GetMapping(path = "name/{name}")
    public ResponseEntity<ApiResponse<List<Food>>> getFoodItemByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(foodServices.getFoodItemByName(name));
    }

    @GetMapping(path = "hotel/{hotelId}")
    public ResponseEntity<ApiResponse<List<Food>>> getFoodItemByHotelId(@PathVariable("hotelId") String hotelId) {
        return ResponseEntity.ok(foodServices.getFoodItemByHotelId(hotelId));
    }

    @GetMapping(path = "cuisine/{cuisine}")
    public ResponseEntity<ApiResponse<List<Food>>> getFoodItemByCuisine(@PathVariable("cuisine") String cuisine) {
        return ResponseEntity.ok(foodServices.getFoodItemByCuisine(cuisine));
    }

    @GetMapping(path = "availability/{availability}")
    public ResponseEntity<ApiResponse<List<Food>>> getFoodItemByAvailability(@PathVariable("availability") boolean availability) {
        return ResponseEntity.ok(foodServices.getFoodItemByAvailability(availability));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Food>> addFoodItem(@RequestBody FoodRequest food) {
        return ResponseEntity.ok(foodServices.addFoodItem(food));
    }

    @PostMapping(path = "list")
    public ResponseEntity<ApiResponse<String>> addFoodItemsList(@RequestBody List<FoodRequest> foodList) {
        return ResponseEntity.ok(foodServices.addFoodItemsList(foodList));
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<ApiResponse<Food>> updateFoodItem(@PathVariable("id") String id, @RequestBody FoodRequest food) {
        return ResponseEntity.ok(foodServices.updateFoodItem(id, food));
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable("id") String id) {
        foodServices.deleteFoodItem(id);
        return ResponseEntity.noContent().build();
    }
}
