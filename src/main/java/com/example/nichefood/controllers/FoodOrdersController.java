package com.example.nichefood.controllers;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.food.OrderRequest;
import com.example.nichefood.models.FoodOrders;
import com.example.nichefood.services.FoodOrdersServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/orders")
public class FoodOrdersController {

    private FoodOrdersServices foodOrdersServices;

    @GetMapping(path = "")
    public ResponseEntity<ApiResponse<List<FoodOrders>>> getAllFoodOrders(){
        return ResponseEntity.ok(
                this.foodOrdersServices.getAllOrders()
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ApiResponse<FoodOrders>> getFoodOrderById(@PathVariable("id") String id){
        return ResponseEntity.ok(
                this.foodOrdersServices.getAllOrdersById(id)
        );
    }

    @PostMapping(path = "placeOrder")
    public ResponseEntity<ApiResponse<FoodOrders>> placeOrder(@RequestBody OrderRequest orderRequest){
        return ResponseEntity.ok(
                this.foodOrdersServices.placeOrder(orderRequest)
        );
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOrder(@PathVariable("id") String id){
        return ResponseEntity.ok(
                this.foodOrdersServices.deleteOrder(id)
        );
    }
}
