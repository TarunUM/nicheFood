package com.example.nichefood.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Order {
    private String id;
    private String customerId;
    private String foodId;
    private int quantity;
    private float totalPrice;
    private String orderStatus;
    private Date orderTime;

    public Order(String customerId, String foodId, int quantity, float totalPrice, String orderStatus) {
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderStatus = orderStatus;
        this.orderTime = new Date();
    }
}
