package com.example.nichefood.Configurations;

import com.example.nichefood.models.Food;
import com.example.nichefood.repositories.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class FoodConfig {

    @Bean
    CommandLineRunner commandLineRunner(FoodRepository foodRepository){
        return args -> {
            Food food1 = new Food(
                    "H123",
                    "Pasta Carbonara",
                    "Classic Italian pasta dish with creamy sauce",
                    200.00,
                    "Italian",
                    "Tomatoes, Cheese, Basil",
                    Arrays.asList("https://example.com/image1.jpg", "https://example.com/image2.jpg"),
                    true
            );

            Food food2 = new Food(
                    "H456",
                    "Chicken Tikka Masala",
                    "Spicy Indian chicken dish with tomato-based sauce",
                    150.0,
                    "Indian",
                    "Chicken, Yogurt, Spices",
                    Arrays.asList("https://example.com/image3.jpg", "https://example.com/image4.jpg", "https://example.com/image5.jpg"),
                    true
            );

            Food food3 = new Food(
                    "H101",
                    "Sushi Roll",
                    "Japanese delicacy with fresh fish and rice",
                    180.0,
                    "Japanese",
                    "Fish, Rice, Seaweed",
                    Arrays.asList("https://example.com/image6.jpg", "https://example.com/image7.jpg", "https://example.com/image8.jpg"),
                    true
            );


            foodRepository.saveAll(
                    List.of(food1, food2, food3)
            );
        };
    }
}
