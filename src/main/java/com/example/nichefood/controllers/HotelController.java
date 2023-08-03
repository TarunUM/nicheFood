package com.example.nichefood.controllers;

import com.example.nichefood.models.Hotel;
import com.example.nichefood.services.HotelServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelServices hotelServices;

    public HotelController(HotelServices hotelServices) {
        this.hotelServices = hotelServices;
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelServices.getAllHotels());
    }

    @GetMapping(params = "hotel_id")
    public ResponseEntity<Hotel> getHotelById(String hotel_id) {
        return ResponseEntity.ok(hotelServices.getHotelById(hotel_id));
    }

    @GetMapping(params = "hotel_name")
    public ResponseEntity<List<Hotel>> getHotelByName(String hotel_name) {
        return ResponseEntity.ok(hotelServices.getHotelByName(hotel_name));
    }

    @GetMapping(params = "city")
    public ResponseEntity<List<Hotel>> getHotelByCity(String city) {
        return ResponseEntity.ok(hotelServices.getHotelByCity(city));
    }

    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelServices.addHotel(hotel));
    }

    @PostMapping("/hotellist")
    public ResponseEntity<String> addHotelList(@RequestBody List<Hotel> hotelList) {
        return ResponseEntity.ok(hotelServices.addHotelList(hotelList));
    }

    @PutMapping(params = "hotel_id")
    public ResponseEntity<Hotel> updateHotel(@RequestParam String hotel_id, @RequestBody Hotel hotel) {
        return ResponseEntity.ok(hotelServices.updateHotel(hotel_id, hotel));
    }

    @DeleteMapping(params = "hotel_id")
    public ResponseEntity<Void> deleteHotelById(@RequestParam String hotel_id) {
        hotelServices.deleteHotelById(hotel_id);
        return ResponseEntity.noContent().build();
    }
}
