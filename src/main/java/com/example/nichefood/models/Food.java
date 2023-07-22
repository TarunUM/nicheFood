package com.example.nichefood.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table
public class Food {
    @Id
    private String id;
    private String hotelId;
    private String name;
    private String description;
    private float price;
    private String cuisine;
    private String ingredients;
    @Lob
    private ArrayList<String> image;
    private boolean availability;

    public Food(String hotelId,
                String name,
                String description,
                float price,
                String cuisine,
                String ingredients,
                ArrayList<String> image,
                boolean availability) {
        this.id = UUID.randomUUID().toString();
        this.hotelId = hotelId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cuisine = cuisine;
        this.ingredients = ingredients;
        this.image = image;
        this.availability = availability;
    }

    public Food(Food food) {
        this.id = UUID.randomUUID().toString();
        this.hotelId = food.hotelId;
        this.name = food.name;
        this.description = food.description;
        this.price = food.price;
        this.cuisine = food.cuisine;
        this.ingredients = food.ingredients;
        this.image = food.image;
        this.availability = food.availability;
    }

    public Food() {

    }
}
