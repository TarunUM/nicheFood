package com.example.nichefood.services;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.hotel.HotelRequest;
import com.example.nichefood.models.Hotel;

import java.util.List;

public interface HotelServices {
    ApiResponse<List<Hotel>> getAllHotels();
    ApiResponse<Hotel> getHotelById(String hotel_id);
    ApiResponse<List<Hotel>> getHotelByName(String hotel_name);
    ApiResponse<List<Hotel>> getHotelByCity(String city);
    ApiResponse<Hotel> addHotel(HotelRequest hotel);
    ApiResponse<String> addHotelList(List<HotelRequest> hotelList);
    ApiResponse<Hotel> updateHotel(String id, HotelRequest hotel);
    void deleteHotelById(String hotel_id);
}
