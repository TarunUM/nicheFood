package com.example.nichefood.controllers;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.hotel.HotelRequest;
import com.example.nichefood.models.Hotel;
import com.example.nichefood.services.HotelServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
@RequiredArgsConstructor
public class HotelController {
    private final HotelServices hotelServices;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Hotel>>> getAllHotels() {
        return ResponseEntity.ok(hotelServices.getAllHotels());
    }

    @GetMapping("/{hotel_id}")
    public ResponseEntity<ApiResponse<Hotel>> getHotelById(@PathVariable String hotel_id) {
        return ResponseEntity.ok(hotelServices.getHotelById(hotel_id));
    }

    @GetMapping("/name/{hotel_name}")
    public ResponseEntity<ApiResponse<List<Hotel>>> getHotelByName(@PathVariable String hotel_name) {
        return ResponseEntity.ok(hotelServices.getHotelByName(hotel_name));
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<ApiResponse<List<Hotel>>> getHotelByCity(@PathVariable String city) {
        return ResponseEntity.ok(hotelServices.getHotelByCity(city));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Hotel>> addHotel(@RequestBody HotelRequest hotel) {
        return ResponseEntity.ok(hotelServices.addHotel(hotel));
    }

    @PostMapping("/list")
    public ResponseEntity<ApiResponse<String>> addHotelList(@RequestBody List<HotelRequest> hotelList) {
        return ResponseEntity.ok(hotelServices.addHotelList(hotelList));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Hotel>> updateHotel(@PathVariable String id,
                                                          @RequestBody HotelRequest hotel) {
        return ResponseEntity.ok(hotelServices.updateHotel(id, hotel));
    }

    @DeleteMapping("/{hotel_id}")
    public ResponseEntity<ApiResponse<String>> deleteHotelById(@PathVariable String hotel_id) {
        hotelServices.deleteHotelById(hotel_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<ApiResponse<String>> test() {
        return ResponseEntity.ok(ApiResponse.<String>builder()
                .status(HttpStatus.OK)
                .timestamp(Instant.now())
                .message("test")
                .build());
    }
}
