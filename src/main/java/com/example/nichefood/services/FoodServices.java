package com.example.nichefood.services;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.food.FoodRequest;
import com.example.nichefood.models.Food;

import java.util.List;
import java.util.Optional;

public interface FoodServices {
    ApiResponse<List<Food>> getFoodItems();
    ApiResponse<Food> getFoodItemById(String id);
    ApiResponse<List<Food>> getFoodItemByName(String name);
    ApiResponse<List<Food>> getFoodItemByHotelId(String hotelId);
    ApiResponse<List<Food>> getFoodItemByCuisine(String cuisine);
    ApiResponse<List<Food>> getFoodItemByAvailability(boolean availability);
    ApiResponse<Food> addFoodItem(FoodRequest food);
    ApiResponse<String> addFoodItemsList(List<FoodRequest> foodList);
    ApiResponse<Food> updateFoodItem(String id, FoodRequest food);
    void deleteFoodItem(String id);
}
