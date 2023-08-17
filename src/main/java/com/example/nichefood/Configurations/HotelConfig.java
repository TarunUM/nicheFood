package com.example.nichefood.Configurations;

import com.example.nichefood.models.Hotel;

import com.example.nichefood.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HotelConfig {

    @Bean
    CommandLineRunner hotelCommandRunner(HotelRepository hotelRepository) {
        return args -> {

            Hotel hotel1 = Hotel.builder()
                    .hotel_id("fb1658c2-67ea-4258-b266-cb89eba4be34")
                    .hotel_name("Luxury Resort")
                    .phone("+1-555-123-4567")
                    .email("info@luxuryresort.com")
                    .rating(4.8)
                    .city("New York")
                    .description("Experience the ultimate luxury at our resort with breathtaking views.")
                    .image(List.of(
                            "https://example.com/images/image1.jpg",
                            "https://example.com/images/image2.jpg",
                            "https://example.com/images/image3.jpg"
                    ))
                    .build();

            Hotel hotel2 = new Hotel(
                    "5603c8cc-bf66-4a06-8391-c32629345234",
                    "Cozy Inn",
                    "456 Oak Avenue",
                    "+1-555-987-6543",
                    "info@cozyinn.com",
                    4.2,
                    "Chicago",
                    "Enjoy a warm and cozy stay in the heart of the city.",
                    List.of(
                            "https://example.com/images/image4.jpg",
                            "https://example.com/images/image5.jpg",
                            "https://example.com/images/image6.jpg"
                    )
            );

            Hotel hotel3 = new Hotel(
                    "81f885ee-29dc-46ad-90ae-43968e709a52",
                    "Seaside Resort",
                    "789 Beach Road",
                    "+1-555-987-1234",
                    "info@seasideresort.com",
                    4.5,
                    "Miami",
                    "Experience a relaxing stay with stunning ocean views.",
                    List.of(
                            "https://example.com/images/image7.jpg",
                            "https://example.com/images/image8.jpg",
                            "https://example.com/images/image9.jpg"
                    )
            );

            hotelRepository.saveAllAndFlush(List.of(hotel1, hotel2, hotel3));
        };
    }
}
