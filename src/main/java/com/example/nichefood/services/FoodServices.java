package com.example.nichefood.services;

import com.example.nichefood.models.Food;

import java.util.List;
import java.util.Optional;

public interface FoodServices {
    List<Food> getFoodItems();
    Optional<Food> getFoodItemById(String id);
    Optional<Food> getFoodItemByHotelId(String hotelId);
    Optional<Food> getFoodItemByCuisine(String cuisine);
    boolean getFoodItemByAvailability(boolean availability);
    Food addFoodItem(Food food);
    Optional<Food> updateFoodItem(Food food);
    void deleteFoodItem(String id);
}
