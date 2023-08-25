package com.example.nichefood.Configurations;

import com.example.nichefood.models.Food;
import com.example.nichefood.repositories.FoodRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class FoodConfig {

//    @Bean
//    CommandLineRunner commandLineRunner(FoodRepository foodRepository){
//        return args -> {
//
//            Food food1 = Food.builder()
//                    .image(Arrays.asList("https://example.com/image1.jpg", "https://example.com/image2.jpg"))
//                    .price(200.00)
//                    .availability(true)
//                    .cuisine("Italian")
//                    .description("Classic Italian pasta dish with creamy sauce")
//                    .ingredients("Tomatoes, Cheese, Basil")
//                    .name("Pasta Carbonara")
//                    .build();
//
//            Food food2 = Food.builder()
//                    .image(Arrays.asList("https://example.com/image3.jpg", "https://example.com/image4.jpg", "https://example.com/image5.jpg"))
//                    .availability(true)
//                    .price(150.00)
//                    .cuisine("Indian")
//                    .description("Spicy Indian chicken dish with tomato-based sauce")
//                    .ingredients("Chicken, Yogurt, Spices")
//                    .name("Chicken Tikka Masala")
//                    .build();
//
//
//            Food food3 = Food.builder()
//                    .image(Arrays.asList("https://example.com/image6.jpg", "https://example.com/image7.jpg", "https://example.com/image8.jpg"))
//                    .availability(true)
//                    .price(180.00)
//                    .cuisine("Japanese")
//                    .description("Japanese delicacy with fresh fish and rice")
//                    .ingredients("Fish, Rice, Seaweed")
//                    .name("Sushi Roll")
//                    .build();
//
//            foodRepository.saveAllAndFlush(
//                    List.of(food1, food2, food3)
//            );
//        };
//    }
}
