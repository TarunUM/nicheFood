package com.example.nichefood.Configurations;

import com.example.nichefood.models.Hotel;

import com.example.nichefood.models.utils.Address;
import com.example.nichefood.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.List;

@Configuration
public class HotelConfig {

//    @Bean
//    CommandLineRunner hotelCommandRunner(HotelRepository hotelRepository) {
//        return args -> {
//            Hotel hotel1 = Hotel.builder()
//                    .hotel_name("Luxury Resort")
//                    .email("info@luxuryresort.com")
//                    .image(List.of(
//                            "https://example.com/images/image1.jpg",
//                            "https://example.com/images/image2.jpg",
//                            "https://example.com/images/image3.jpg"
//                    ))
//                    .phone("+1-555-123-4567")
//                    .address(Address.builder().street("1540 Decatur St, Ridge wood").city("New York").state("NY").country("USA").zipCode("11385").build())
//                    .rating(4.8)
//                    .description("Experience the ultimate luxury at our resort with breathtaking views.")
//                    .createdAt(new Date())
//                    .build();
//
//            Hotel hotel2 = Hotel.builder()
//                    .hotel_name("Cozy Inn")
//                    .email("info@cozyinn.com")
//                    .address(Address.builder().street("2806 W 40th Pl, Chicago").city("Chicago").state("IL").zipCode("60632").country("USA").build())
//                    .image(List.of(
//                            "https://example.com/images/image4.jpg",
//                            "https://example.com/images/image5.jpg",
//                            "https://example.com/images/image6.jpg"
//                    ))
//                    .rating(4.2)
//                    .phone("+1-555-987-6543")
//                    .description("Enjoy a warm and cozy stay in the heart of the city.")
//                    .createdAt(new Date())
//                    .build();
//
//            Hotel hotel3 = Hotel.builder()
//                    .hotel_name("Seaside Resort")
//                    .email("info@seasideresort.com")
//                    .address(Address.builder().street("900 S Miami Ave #133").city("Miami").state("FL").zipCode("33130").country("USA").build())
//                    .image(List.of(
//                            "https://example.com/images/image7.jpg",
//                            "https://example.com/images/image8.jpg",
//                            "https://example.com/images/image9.jpg"
//                    ))
//                    .description("Experience a relaxing stay with stunning ocean views.")
//                    .rating(4.5)
//                    .phone("+1-555-987-1234")
//                    .createdAt(new Date())
//                    .build();
//
//            hotelRepository.saveAllAndFlush(List.of(hotel1, hotel2, hotel3));
//        };
//    }
}
