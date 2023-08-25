package com.example.nichefood.repositories;

import com.example.nichefood.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodRepository
        extends JpaRepository<Food, UUID> {
    @Query("SELECT f FROM Food f WHERE f.name = ?1")
    List<Food> findByName(String name);

    @Query("SELECT f FROM Food f WHERE f.hotel.hotel_id = ?1")
    List<Food> findByHotelId(UUID hotelId);

    @Query("SELECT f FROM Food f WHERE f.cuisine = ?1")
    List<Food> findByCuisine(String cuisine);

    @Query("SELECT f FROM Food f WHERE f.availability = ?1")
    List<Food> findByAvailability(boolean availability);
}
