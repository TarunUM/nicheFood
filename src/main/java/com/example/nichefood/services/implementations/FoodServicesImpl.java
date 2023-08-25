package com.example.nichefood.services.implementations;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.food.FoodRequest;
import com.example.nichefood.exceptions.GeneralExceptions;
import com.example.nichefood.models.Food;
import com.example.nichefood.repositories.FoodRepository;
import com.example.nichefood.repositories.HotelRepository;
import com.example.nichefood.services.FoodServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FoodServicesImpl implements FoodServices {

    private final FoodRepository foodRepository;
    private final HotelServicesImpl hotelServices;
    private final HotelRepository hotelRepository;

    @Override
    public ApiResponse<List<Food>> getFoodItems() {
        try {
            List<Food> foods = foodRepository.findAll();
            return new ApiResponse<>(HttpStatus.OK,
                    Instant.now(),
                    "Food items fetched successfully",
                    foods.size(),
                    foods);
        } catch(Exception e) {
            throw new GeneralExceptions("Error while fetching food items");
        }
    }

    @Override
    public ApiResponse<Food> getFoodItemById(String id) {
        try {
            return new ApiResponse<>(HttpStatus.OK,
                    Instant.now(),
                    "Food item fetched successfully",
                    1,
                    foodRepository.findById(UUID.fromString(id)).orElseThrow(
                            () -> new GeneralExceptions("Food item not found")
                    ));
        } catch(Exception e) {
            throw new GeneralExceptions("Error while fetching food item");
        }
    }

    @Override
    public ApiResponse<List<Food>> getFoodItemByName(String name) {
        try{
            List<Food> foods = foodRepository.findByName(name);
            return new ApiResponse<>(HttpStatus.OK,
                    Instant.now(),
                    "Food items fetched successfully",
                    foods.size(),
                    foods);
        } catch(Exception e) {
            throw new GeneralExceptions("Error while fetching food item");
        }
    }

    @Override
    public ApiResponse<List<Food>> getFoodItemByHotelId(String hotelId) {
        try {
            List<Food> foodList = foodRepository.findByHotelId(UUID.fromString(hotelId));
            return new ApiResponse<>(HttpStatus.OK,
                    Instant.now(),
                    "Food items fetched successfully",
                    foodList.size(),
                    foodList);
        } catch(Exception e) {
            throw new GeneralExceptions("Error while fetching food item");
        }
    }

    @Override
    public ApiResponse<List<Food>> getFoodItemByCuisine(String cuisine) {
        try{
            List<Food> foods = foodRepository.findByCuisine(cuisine);
            return new ApiResponse<>(HttpStatus.OK,
                    Instant.now(),
                    "Food items fetched successfully",
                    foods.size(),
                    foods);
        } catch(Exception e) {
            throw new GeneralExceptions("Error while fetching food item");
        }
    }

    @Override
    public ApiResponse<List<Food>> getFoodItemByAvailability(boolean availability) {
        try{
            List<Food> foods = foodRepository.findByAvailability(availability);
            return new ApiResponse<>(HttpStatus.OK,
                    Instant.now(),
                    "Food items fetched successfully",
                    foods.size(),
                    foods);
        } catch(Exception e) {
            throw new GeneralExceptions("Error while fetching food item");
        }
    }

    @Override
    public ApiResponse<Food> addFoodItem(FoodRequest foodRequest) {
        try {
            Food food = Food.builder()
                    .hotel(hotelServices.getHotelById(foodRequest.getHotel_id()).getData())
                    .name(foodRequest.getName())
                    .description(foodRequest.getDescription())
                    .price(foodRequest.getPrice())
                    .cuisine(foodRequest.getCuisine())
                    .ingredients(foodRequest.getIngredients())
                    .image(foodRequest.getImage())
                    .availability(foodRequest.isAvailability())
                    .build();
            food = foodRepository.saveAndFlush(food);
            return new ApiResponse<>(HttpStatus.OK,
                    Instant.now(),
                    "Food item added successfully",
                    1,
                    food);
        } catch(Exception e) {
            throw new GeneralExceptions("Error while adding food item");
        }
    }

    @Override
    public ApiResponse<String> addFoodItemsList(List<FoodRequest> foodList) {
        try {
            for (FoodRequest foodRequest: foodList) {
                addFoodItem(foodRequest);
            }
            return ApiResponse.<String>builder()
                    .timestamp(Instant.now())
                    .message("Food items added successfully")
                    .status(HttpStatus.OK)
                    .build();
        } catch(Exception e) {
            throw new GeneralExceptions("Error while adding food items");
        }
    }

    @Override
    public ApiResponse<Food> updateFoodItem(String id, FoodRequest food) {
        try {
            Food foodItem = foodRepository.findById(UUID.fromString(id)).orElseThrow(
                    () -> new GeneralExceptions("Food item not found")
            );

            if (food.getHotel_id() != null && hotelRepository.existsById(UUID.fromString(food.getHotel_id()))){
                foodItem.setHotel(hotelServices.getHotelById(food.getHotel_id()).getData());
            }
            if (food.getName() != null){
                foodItem.setName(food.getName());
            }
            if (food.getDescription() != null){
                foodItem.setDescription(food.getDescription());
            }
            if (food.getPrice() != 0){
                foodItem.setPrice(food.getPrice());
            }
            if (food.getCuisine() != null){
                foodItem.setCuisine(food.getCuisine());
            }
            if (food.getIngredients() != null){
                foodItem.setIngredients(food.getIngredients());
            }
            if (food.getImage() != null){
                foodItem.setImage(food.getImage());
            }
            if (!food.isAvailability()){
                foodItem.setAvailability(false);
            }
            foodItem = foodRepository.save(foodItem);
            return new ApiResponse<>(HttpStatus.OK,
                    Instant.now(),
                    "Food item updated successfully",
                    1,
                    foodItem);
        } catch(Exception e) {
            throw new GeneralExceptions("Error while updating food item");
        }
    }

    @Override
    public void deleteFoodItem(String id) {
        try {
            if (!foodRepository.existsById(UUID.fromString(id))){
                throw new GeneralExceptions("Food item not found");
            }

            foodRepository.deleteById(UUID.fromString(id));
        } catch(Exception e) {
            throw new GeneralExceptions("Error while deleting food item");
        }
    }
}
