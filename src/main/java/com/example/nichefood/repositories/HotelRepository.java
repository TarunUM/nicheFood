package com.example.nichefood.repositories;

import com.example.nichefood.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, String> {

//    @Query("SELECT h FROM Hotel h WHERE h.hotel_name like %?1%")
//    List<Hotel> findByHotelName(String hotel_name);
//
//    @Query("SELECT h FROM Hotel h WHERE h.hotel_name = ?1 AND h.email = ?2")
//    Optional<Hotel> findByHotelIdAndEmail(String hotel_name, String email);
//
//    @Query("SELECT h FROM Hotel h WHERE h.city = ?1")
//    List<Hotel> findByCity(String city);
}
