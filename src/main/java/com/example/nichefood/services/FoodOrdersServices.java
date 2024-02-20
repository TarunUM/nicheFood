package com.example.nichefood.services;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.food.OrderRequest;
import com.example.nichefood.models.FoodOrders;

import java.util.List;

public interface FoodOrdersServices {
    ApiResponse<List<FoodOrders>> getAllOrders();

    ApiResponse<FoodOrders> getAllOrdersById(String Id);

    ApiResponse<FoodOrders> placeOrder(OrderRequest orderRequest);

    ApiResponse<Void> deleteOrder(String id);

}
