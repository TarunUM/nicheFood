package com.example.nichefood.controllers;

import com.example.nichefood.models.Food;
import com.example.nichefood.services.implementations.FoodServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/food")
public class FoodController {
//
//    private final FoodServicesImpl foodServices;
//
//    @Autowired
//    public FoodController(FoodServicesImpl foodServices) {
//        this.foodServices = foodServices;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Food>> getFoodItems() {
//        return ResponseEntity.ok().body(foodServices.getFoodItems());
//    }
//
//    @GetMapping(params = "id")
//    public ResponseEntity<Food> getFoodItemById(@RequestParam(name = "id") String id) {
//        return ResponseEntity.ok().body(foodServices.getFoodItemById(id));
//    }
//
//    @GetMapping(params = "name")
//    public ResponseEntity<List<Food>> getFoodItemByName(@RequestParam(name = "name") String name) {
//        return ResponseEntity.ok().body(foodServices.getFoodItemByName(name));
//    }
//
//    @GetMapping(params = "hotelId")
//    public ResponseEntity<List<Food>> getFoodItemByHotelId(@RequestParam(name = "hotelId") String hotelId) {
//        return ResponseEntity.ok().body(foodServices.getFoodItemByHotelId(hotelId));
//    }
//
//    @GetMapping(params = "cuisine")
//    public ResponseEntity<List<Food>> getFoodItemByCuisine(@RequestParam(name = "cuisine") String cuisine) {
//        return ResponseEntity.ok().body(foodServices.getFoodItemByCuisine(cuisine));
//    }
//
//    @GetMapping(params = "availability")
//    public ResponseEntity<List<Food>> getFoodItemByAvailability(@RequestParam(name = "availability") boolean availability) {
//        return ResponseEntity.ok().body(foodServices.getFoodItemByAvailability(availability));
//    }
//
////    @PostMapping
////    public ResponseEntity<Food> addFoodItem(@RequestBody Food food) {
////        return ResponseEntity.status(HttpStatus.CREATED).body(foodServices.addFoodItem(food));
////    }
////
////    @PostMapping("/list")
////    public ResponseEntity<String> addFoodItemsList(@RequestBody List<Food> foodList) {
////        return ResponseEntity.status(HttpStatus.CREATED).body(foodServices.addFoodItemsList(foodList));
////    }
//
//    @PatchMapping(path = "id")
//    public ResponseEntity<Food> updateFoodItem(@RequestParam(name = "id") String id,@RequestBody Food food) {
//        return ResponseEntity.ok().body(foodServices.updateFoodItem(id, food));
//    }
//
//    @DeleteMapping(path = "id")
//    public ResponseEntity<String> deleteFoodItem(@RequestParam(name = "id") String id) {
//        foodServices.deleteFoodItem(id);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Food item deleted");
//    }
}
