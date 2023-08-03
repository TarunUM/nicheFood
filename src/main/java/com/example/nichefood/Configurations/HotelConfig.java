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
    CommandLineRunner hotelCommandRunner(HotelRepository hotelRepository){
        return args -> {
            Hotel hotel1 = new Hotel(
                    "Luxury Resort","123 Main Street",
                    "+1-555-123-4567",
                    "info@luxuryresort.com",
                    4.8,
                    "New York",
                    "Experience the ultimate luxury at our resort with breathtaking views.",
                    List.of(
                            "https://example.com/images/image1.jpg",
                            "https://example.com/images/image2.jpg",
                            "https://example.com/images/image3.jpg"
                    )
            );
            Hotel hotel2 = new Hotel(
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

//            Hotel hotel1 = new Hotel(
//                    "1",
//                    "Hotel 1",
//                    "Address 1",
//                    "City 1",
//                    "State 1",
//                    "Country 1",
//                    "Zip 1",
//                    "Phone 1",
//                    "Fax 1",
//                    "Email 1",
//                    "Website 1",
//                    "Description 1",
//                    "Image 1",
//                    "Rating 1",
//                    "Latitude 1",
//                    "Longitude 1",
//                    "Room 1",
//                    "Price 1",
//                    "Amenities 1",
//                    "Review"
//            );
        };
    }
}
