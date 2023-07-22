package com.example.nichefood.services.implementations;

import com.example.nichefood.models.Food;
import com.example.nichefood.repositories.FoodRepository;
import com.example.nichefood.services.FoodServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodServicesImpl implements FoodServices {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodServicesImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> getFoodItems() {
        return foodRepository.findAll();
    }

    @Override
    public Optional<Food> getFoodItemById(String id) {
        return foodRepository.findById(id);
    }

    @Override
    public Optional<Food> getFoodItemByHotelId(String hotelId) {
        return foodRepository.findBy('hotelId');
    }

    @Override
    public Optional<Food> getFoodItemByCuisine(String cuisine) {
        return foodRepository.findBy('cuisine')
    }

    @Override
    public boolean getFoodItemByAvailability(boolean availability) {
        return foodRepository.findBy('availability');
    }

    @Override
    public Food addFoodItem(Food food) {
        return foodRepository.saveAndFlush(food);
    }

    @Override
    public Optional<Food> updateFoodItem(Food food) {
        Food oldFood = foodRepository.findById(food.getId()).orElse(null);
        if (oldFood != null) {
            oldFood.setHotelId(food.getHotelId());
            oldFood.setName(food.getName());
            oldFood.setDescription(food.getDescription());
            oldFood.setPrice(food.getPrice());
            oldFood.setCuisine(food.getCuisine());
            oldFood.setIngredients(food.getIngredients());
            oldFood.setImage(food.getImage());
            oldFood.setAvailability(food.isAvailability());
            return Optional.of(foodRepository.saveAndFlush(oldFood));
        }
        return Optional.of(new Food());
    }


    @Override
    public void deleteFoodItem(String id) {
        foodRepository.deleteById(id);
    }

}
