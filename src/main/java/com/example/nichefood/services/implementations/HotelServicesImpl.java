package com.example.nichefood.services.implementations;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.hotel.HotelRequest;
import com.example.nichefood.exceptions.GeneralExceptions;
import com.example.nichefood.models.Hotel;
import com.example.nichefood.models.utils.Address;
import com.example.nichefood.repositories.HotelRepository;
import com.example.nichefood.services.HotelServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class HotelServicesImpl implements HotelServices {
    private final HotelRepository hotelRepository;

    @Override
    public ApiResponse<List<Hotel>> getAllHotels() {
        try {
            return ApiResponse.<List<Hotel>>builder()
                    .status(HttpStatus.OK)
                    .timestamp(Instant.now())
                    .message("Successfully get all hotels")
                    .length(hotelRepository.findAll().size())
                    .data(hotelRepository.findAll())
                    .build();
        } catch (Exception e) {
            throw new GeneralExceptions("Error while getting all hotels");
        }
    }

    @Override
    public ApiResponse<Hotel> getHotelById(String hotel_id) {
        try {
            return ApiResponse.<Hotel>builder()
                    .status(HttpStatus.OK)
                    .timestamp(Instant.now())
                    .message("Successfully get hotel by id")
                    .length(1)
                    .data(hotelRepository.findById(UUID.fromString(hotel_id)).orElseThrow(
                            () -> new GeneralExceptions(HttpStatus.NOT_FOUND,"Hotel not found" + hotel_id)))
                    .build();
        } catch (RuntimeException e) {
            throw new GeneralExceptions("Error while getting hotel");
        }
    }

    @Override
    public ApiResponse<List<Hotel>> getHotelByName(String hotel_name) {
        try {
            return ApiResponse.<List<Hotel>>builder()
                    .status(HttpStatus.OK)
                    .timestamp(Instant.now())
                    .message("Successfully get hotel by name")
                    .length(hotelRepository.findByName(hotel_name).size())
                    .data(hotelRepository.findByName(hotel_name))
                    .build();
        } catch (Exception e) {
            throw new GeneralExceptions("Error while getting hotel by name");
        }
    }

    @Override
    public ApiResponse<List<Hotel>> getHotelByCity(String city) {
        try {
            return ApiResponse.<List<Hotel>>builder()
                    .status(HttpStatus.OK)
                    .timestamp(Instant.now())
                    .message("Successfully get hotel by city")
                    .length(hotelRepository.findByCity(city).size())
                    .data(hotelRepository.findByCity(city))
                    .build();
        } catch (Exception e) {
            throw new GeneralExceptions("Error while getting hotel by city");
        }
    }

    @Override
    public ApiResponse<Hotel> addHotel(HotelRequest hotel) {
        try {
            Hotel newHotel = Hotel.builder()
                    .hotel_name(hotel.getHotel_name())
                    .phone(hotel.getPhone())
                    .description(hotel.getDescription())
                    .image(hotel.getImage())
                    .email(hotel.getEmail())
                    .address(Address.builder()
                            .city(hotel.getCity())
                            .country(hotel.getCountry())
                            .street(hotel.getStreet())
                            .state(hotel.getState())
                            .zipCode(hotel.getZipCode())
                            .build())
                    .createdAt(new Date())
                    .build();

            return ApiResponse.<Hotel>builder()
                    .status(HttpStatus.CREATED)
                    .timestamp(Instant.now())
                    .message("Successfully added hotel")
                    .length(1)
                    .data(hotelRepository.save(newHotel))
                    .build();

        } catch (Exception e) {
            throw new GeneralExceptions("Error while adding hotel");
        }
    }

    @Override
    public ApiResponse<String> addHotelList(List<HotelRequest> hotelList) {
        try {
            for (HotelRequest hotel : hotelList) {
                addHotel(hotel);
            }
            return ApiResponse.<String>builder()
                    .status(HttpStatus.CREATED)
                    .timestamp(Instant.now())
                    .message("Successfully added hotel list")
                    .length(hotelList.size())
                    .data("Successfully added hotel list")
                    .build();
        } catch (Exception e) {
            throw new GeneralExceptions("Error while adding hotel list");
        }
    }

    @Override
    @Transient
    public ApiResponse<Hotel> updateHotel(String id, HotelRequest hotel) {
        try {
            Hotel oldHotel = hotelRepository.findById(
                    UUID.fromString(id)).orElseThrow(
                            () -> new GeneralExceptions("Hotel not found")
            );

            Address address = oldHotel.getAddress();
            if (hotel.getZipCode() != null && !hotel.getZipCode().equals("")){
                address.setZipCode(hotel.getZipCode());
            }
            if (hotel.getCity() != null && !hotel.getCity().equals("")){
                address.setCity(hotel.getCity());
            }
            if (hotel.getCountry() != null && !hotel.getCountry().equals("")){
                address.setCountry(hotel.getCountry());
            }
            if (hotel.getState() != null && !hotel.getState().equals("")){
                address.setState(hotel.getState());
            }
            if (hotel.getStreet() != null && !hotel.getStreet().equals("")){
                address.setStreet(hotel.getStreet());
            }
            if (hotel.getHotel_name() != null && !hotel.getHotel_name().equals("")){
                oldHotel.setHotel_name(hotel.getHotel_name());
            }
            if (address != null){
                oldHotel.setAddress(address);
            }
            if (hotel.getPhone() != null && !hotel.getPhone().equals("")){
                oldHotel.setPhone(hotel.getPhone());
            }
            if (hotel.getEmail() != null && !hotel.getEmail().equals("")){
                oldHotel.setEmail(hotel.getEmail());
            }
            if (hotel.getDescription() != null && !hotel.getDescription().equals("")){
                oldHotel.setDescription(hotel.getDescription());
            }
            if (hotel.getImage() != null){
                List<String> images = oldHotel.getImage();
                images.addAll(hotel.getImage());
                oldHotel.setImage(images);
            }

            return ApiResponse.<Hotel>builder()
                    .status(HttpStatus.OK)
                    .timestamp(Instant.now())
                    .message("Successfully updated hotel")
                    .length(1)
                    .data(hotelRepository.save(oldHotel))
                    .build();

        } catch (Exception e) {
            throw new GeneralExceptions("Error while updating hotel");
        }
    }

    @Override
    public void deleteHotelById(String hotel_id) {
        try {
            if (!hotelRepository.existsById(UUID.fromString(hotel_id))){
                throw new GeneralExceptions(HttpStatus.NOT_FOUND,"Hotel not found");
            }

            hotelRepository.deleteById(UUID.fromString(hotel_id));
            ApiResponse.<String>builder()
                    .status(HttpStatus.OK)
                    .timestamp(Instant.now())
                    .message("Successfully deleted hotel")
                    .build();
        } catch (Exception e) {
            throw new GeneralExceptions("Error while deleting hotel");
        }
    }
}
