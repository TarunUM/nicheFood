package com.example.nichefood.services.implementations;

import com.example.nichefood.exceptions.HotelExceptions;
import com.example.nichefood.models.Hotel;
import com.example.nichefood.repositories.HotelRepository;
import com.example.nichefood.services.HotelServices;
import jakarta.persistence.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServicesImpl implements HotelServices {

    private final HotelRepository hotelRepository;

    @Autowired
    public HotelServicesImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public List<Hotel> getAllHotels() {
        try {
            return hotelRepository.findAll();
        } catch (Exception e) {
            throw new HotelExceptions("Error while getting all hotels", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Hotel getHotelById(String hotel_id) {
        try {
            return hotelRepository.findById(hotel_id).orElseThrow(
                    () -> new HotelExceptions("Hotel not found", HttpStatus.NOT_FOUND)
            );
        } catch (Exception e) {
            throw new HotelExceptions(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Hotel> getHotelByName(String hotel_name) {
        try {
            String[] hotelNameArray = hotel_name.split(",");
            List<Hotel> hotelList = new ArrayList<>();
            for (String hotelName : hotelNameArray) {
                hotelName = hotelName.trim();
                hotelList.addAll(hotelRepository.findByHotelName(hotelName));
            }
            return hotelList;
        } catch (Exception e) {
            throw new HotelExceptions("Hotel not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Hotel> getHotelByCity(String city) {
        try {
            String[] cityArray = city.split(",");
            List<Hotel> hotelList = new ArrayList<>();
            for (String city1 : cityArray) {
                city1 = city1.trim();
                hotelList.addAll(hotelRepository.findByCity(city1));
            }
            return hotelList;
        } catch (Exception e) {
            throw new HotelExceptions("Hotel not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        try {
            return hotelRepository.saveAndFlush(new Hotel(hotel));
        } catch (Exception e) {
            throw new HotelExceptions("Error while adding hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public String addHotelList(List<Hotel> hotelList) {
        try {
            int totalItemsAdded = 0;
            List<String> existingHotels = new ArrayList<>();
            for (Hotel hotel : hotelList) {
                if (!hotelRepository.findByHotelIdAndEmail(hotel.getHotel_name(), hotel.getEmail()).isEmpty()) {
                    existingHotels.add(hotel.getHotel_name());
                } else {
                    hotelRepository.saveAndFlush(new Hotel(hotel));
                    totalItemsAdded++;
                }
            }
            if (totalItemsAdded == hotelList.size()){
                return "Successfully added all hotels";
            }
            return "Successfully added " + totalItemsAdded + " hotels. " + existingHotels + " already exists";
        } catch (Exception e) {
            throw new HotelExceptions("Error while adding hotel list", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transient
    public Hotel updateHotel(String id,Hotel hotel) {
        try {
            if (hotelRepository.findById(id).isEmpty()){
                throw new HotelExceptions("Hotel not found", HttpStatus.NOT_FOUND);
            }
            Hotel hotel1 = hotelRepository.findById(id).get();
            if (hotel.getHotel_name() != null && !hotel.getHotel_name().equals(hotel1.getHotel_name())){
                hotel1.setHotel_name(hotel.getHotel_name());
            }
            if (hotel.getAddress() != null && !hotel.getAddress().equals(hotel1.getAddress())){
                hotel1.setAddress(hotel.getAddress());
            }
            if (hotel.getPhone() != null && !hotel.getPhone().equals(hotel1.getPhone())){
                hotel1.setPhone(hotel.getPhone());
            }
            if (hotel.getEmail() != null && !hotel.getEmail().equals(hotel1.getEmail())){
                hotel1.setEmail(hotel.getEmail());
            }
            if (hotel.getRating() != 0 && hotel.getRating() != hotel1.getRating()){
                hotel1.setRating(hotel.getRating());
            }
            if (hotel.getCity() != null && !hotel.getCity().equals(hotel1.getCity())){
                hotel1.setCity(hotel.getCity());
            }
            if (hotel.getDescription() != null && !hotel.getDescription().equals(hotel1.getDescription())){
                hotel1.setDescription(hotel.getDescription());
            }
            if (hotel.getImage() != null && !hotel.getImage().equals(hotel1.getImage())){
                hotel1.setImage(hotel.getImage());
            }

            return hotelRepository.save(hotel1);
        } catch (Exception e) {
            throw new HotelExceptions("Error while updating hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteHotelById(String hotel_id) {
        try {
            hotelRepository.deleteById(hotel_id);
        } catch (Exception e) {
            throw new HotelExceptions("Error while deleting hotel", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
