package com.example.nichefood.services.implementations;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.food.OrderRequest;
import com.example.nichefood.models.FoodOrders;
import com.example.nichefood.models.users.User;
import com.example.nichefood.repositories.FoodOrdersRepo;
import com.example.nichefood.services.FoodOrdersServices;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class FoodOrdersServicesImpl implements FoodOrdersServices {

    private FoodOrdersRepo foodOrdersRepo;

    @Override
    public ApiResponse<List<FoodOrders>> getAllOrders() {
        var data = this.foodOrdersRepo.findAll();
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Orders fetched successfully", data.size(), data);
    }

    @Override
    public ApiResponse<FoodOrders> getAllOrdersById(String Id) {
        var data = this.foodOrdersRepo.getReferenceById(UUID.fromString(Id));
        return new ApiResponse<>(
                HttpStatus.OK, Instant.now(), "Orders fetched successfully", 1, data
        );
    }

    @Override
    public ApiResponse<FoodOrders> placeOrder(OrderRequest orderRequest) {
        User authentication = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        authentication.getId();
        return null;
    }

    @Override
    public ApiResponse<Void> deleteOrder(String id) {
        return null;
    }
}
