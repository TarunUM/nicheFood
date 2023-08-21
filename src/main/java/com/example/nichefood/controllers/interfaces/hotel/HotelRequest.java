package com.example.nichefood.controllers.interfaces.hotel;

import lombok.*;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class HotelRequest {
    private String hotel_name;
    private String phone;
    private String description;
    private List<String> image;
    private String email;
    private String city;
    private String country;
    private String street;
    private String state;
    private String zipCode;
}
