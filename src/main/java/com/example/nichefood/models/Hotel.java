package com.example.nichefood.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "hotels", uniqueConstraints = {
        @UniqueConstraint(columnNames = "hotel_id", name = "uniqueIdConstraint"),
        @UniqueConstraint(columnNames = "hotel_name", name = "uniqueNameConstraint"),
        @UniqueConstraint(columnNames = "email", name = "uniqueEmailConstraint"),
})
public class Hotel {
    @Id
    @Column(name = "hotel_id", nullable = false, updatable = false)
    private String hotel_id;
    private String hotel_name;
    private String address;
    private String phone;
    private String email;
    private double rating;
    private String city;
    private String description;
    @Lob
    private List<String> image;
    private Date createdAt;

    public Hotel(String hotel_name,
                 String address,
                 String phone,
                 String email,
                 double rating,
                 String city,
                 String description,
                 List<String> image) {
        this.hotel_id = UUID.randomUUID().toString();
        this.hotel_name = hotel_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
        this.city = city;
        this.description = description;
        this.image = image;
        this.createdAt = new Date();
    }

    public Hotel(String hotel_id,
                 String hotel_name,
                 String address,
                 String phone,
                 String email,
                 double rating,
                 String city,
                 String description,
                 List<String> image) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
        this.city = city;
        this.description = description;
        this.image = image;
        this.createdAt = new Date();
    }

    public Hotel(Hotel hotel){
        this.hotel_id = UUID.randomUUID().toString();
        this.hotel_name = hotel.getHotel_name();
        this.address = hotel.getAddress();
        this.phone = hotel.getPhone();
        this.email = hotel.getEmail();
        this.rating = hotel.getRating();
        this.city = hotel.getCity();
        this.description = hotel.getDescription();
        this.image = hotel.getImage();
        this.createdAt = new Date();
    }

    public Hotel(String hotel_id, String hotel_name, String address, String phone, String email, double rating, String city, String description, List<String> image, Date createdAt) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
        this.city = city;
        this.description = description;
        this.image = image;
        this.createdAt = new Date();
    }
}
