package com.example.nichefood.repositories;

import com.example.nichefood.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface HotelRepository
        extends JpaRepository<Hotel, UUID> {

    @Query("SELECT h FROM Hotel h " +
            "WHERE h.address.city LIKE %?1% OR" +
            " h.address.state LIKE %?1% OR " +
            "h.address.country LIKE %?1% OR " +
            "h.address.street LIKE %?1% OR " +
            "h.address.zipCode LIKE %?1%")
    List<Hotel> findByCity(String city);

    @Query("SELECT h FROM Hotel h WHERE h.hotel_name LIKE %?1%")
    List<Hotel> findByName(String name);
}
