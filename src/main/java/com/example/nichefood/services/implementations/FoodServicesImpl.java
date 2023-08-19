package com.example.nichefood.services.implementations;

import com.example.nichefood.exceptions.FoodExceptions;
import com.example.nichefood.models.Food;
import com.example.nichefood.repositories.FoodRepository;
import com.example.nichefood.services.FoodServices;
import jakarta.persistence.Transient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodServicesImpl implements FoodServices {
//
//    private final FoodRepository foodRepository;
//
//    @Override
//    public List<Food> getFoodItems() {
//        return foodRepository.findAll();
//    }
//
//    @Override
//    public Food getFoodItemById(String id) {
//        if (foodRepository.findById(id).isEmpty()) {
//            throw new FoodExceptions("Food not found", HttpStatus.NOT_FOUND);
//        }
//        return foodRepository.findById(id).get();
//    }
//
//    @Override
//    public List<Food> getFoodItemByName(String name) {
//        return foodRepository.findByFoodName(name).orElseThrow(
//                () -> new FoodExceptions("Food not found", HttpStatus.NOT_FOUND)
//        );
//    }
//
//    @Override
//    public List<Food> getFoodItemByHotelId(String hotelId) {
//        if (foodRepository.findByHotel(hotelId).isEmpty()) {
//            throw new FoodExceptions("Hotel not found", HttpStatus.NOT_FOUND);
//        }
//        return foodRepository.findByHotel(hotelId);
//    }
//
//    @Override
//    public List<Food> getFoodItemByCuisine(String cuisine) {
//        if(foodRepository.findByCuisine(cuisine).isEmpty()){
//            throw new FoodExceptions("Cuisine not found",HttpStatus.NOT_FOUND);
//        }
//        return foodRepository.findByCuisine(cuisine);
//    }
//
//    @Override
//    public List<Food> getFoodItemByAvailability(boolean availability) {
//        return foodRepository.findByAvailability(availability);
//    }
//
////    @Override
////    public Food addFoodItem(Food food) {
////        if (foodRepository.findByFoodAndHotelId(food.getName(), food.getHotel_id()).isPresent()) {
////            throw new FoodExceptions("Food already exists", HttpStatus.BAD_REQUEST);
////        }
////        Food save = new Food(food);
////        return foodRepository.saveAndFlush(save);
////    }
//
////    @Override
////    public String addFoodItemsList(List<Food> foodList) {
////        int totalItemsAdded = 0;
////        List<String> foodNames = new ArrayList<>();
////        for (Food food: foodList){
////            if (foodRepository.findByFoodAndHotelId(food.getName(), food.getHotel_id()).isPresent()) {
////                foodNames.add(food.getName());
////            } else {
////                Food save = new Food(food);
////                foodRepository.saveAndFlush(save);
////                totalItemsAdded++;
////            }
////        }
////        if (totalItemsAdded == 0){
////            throw new FoodExceptions("All food items already exists", HttpStatus.BAD_REQUEST);
////        }
////        if (totalItemsAdded == foodList.size()){
////            return "All items added successfully";
////        }
////
////        // Return JSON object
////        return "{ \nTotal items added: " + totalItemsAdded + ",\n" +
////                "Food items already exists: " + (foodList.size()-totalItemsAdded) + ",\n" +
////                "These items can not be added " + foodNames +" \n}";
////    }
//
//    @Override
//    @Transient
//    public Food updateFoodItem(String id, Food food) {
//        Food oldFood = foodRepository.findById(id).orElse(null);
//        if (oldFood == null) {
//            throw new FoodExceptions("Food not found", HttpStatus.NOT_FOUND);
//        }
//        oldFood.setHotel_id(food.getHotel_id());
//        oldFood.setName(food.getName());
//        oldFood.setDescription(food.getDescription());
//        oldFood.setPrice(food.getPrice());
//        oldFood.setCuisine(food.getCuisine());
//        oldFood.setIngredients(food.getIngredients());
//        oldFood.setImage(food.getImage());
//        oldFood.setAvailability(food.isAvailability());
//        return foodRepository.saveAndFlush(oldFood);
//
//    }
//
//    @Override
//    public void deleteFoodItem(String id) {
//        if (!foodRepository.existsById(id)) {
//            throw new FoodExceptions("Food not found", HttpStatus.NOT_FOUND);
//        }
//        foodRepository.deleteById(id);
//    }

}
