package com.example.nichefood.controllers.interfaces.food;

import com.example.nichefood.models.users.Customers;
import com.example.nichefood.models.utils.OrderedFood;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class OrderRequest {
    private Customers customer;
    private OrderedFood[] foods;
}