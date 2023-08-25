package com.example.nichefood.controllers.interfaces.food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class FoodRequest {
    private String hotel_id;
    private String name;
    private String description;
    private double price;
    private String cuisine;
    private String ingredients;
    private List<String> image;
    private boolean availability;
}
