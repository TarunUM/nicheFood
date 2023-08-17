package com.example.nichefood.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "food")
public class Food {
    @Id
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private String id;
    @Column(name = "hotel_id", nullable = false)
    private String hotel_id;
    @Column(name = "name", nullable = false)
    private String name;
    private String description;
    private double price;
    private String cuisine;
    private String ingredients;
    @Lob
    private List<String> image;
    @Column(name = "availability", nullable = false, columnDefinition = "boolean default true")
    private boolean availability;

    public Food(String hotel_id,
                String name,
                String description,
                double price,
                String cuisine,
                String ingredients,
                List<String> image,
                boolean availability) {
        this.id = UUID.randomUUID().toString();
        this.hotel_id = hotel_id;
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
        this.hotel_id = food.hotel_id;
        this.name = food.name;
        this.description = food.description;
        this.price = food.price;
        this.cuisine = food.cuisine;
        this.ingredients = food.ingredients;
        this.image = food.image;
        this.availability = food.availability;
    }
}
