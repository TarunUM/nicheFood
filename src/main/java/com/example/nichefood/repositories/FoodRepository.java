package com.example.nichefood.repositories;

import com.example.nichefood.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FoodRepository
        extends JpaRepository<Food,String> {

    @Query("SELECT f FROM Food f WHERE f.name LIKE %?1%")
    Optional<Food> findByFoodName(String name);

    @Query("SELECT f FROM Food f WHERE f.name = ?1 AND f.hotelId = ?2")
    Optional<Food> findByFoodAndHotelId(String foodName, String hotelId);

    @Query("SELECT f FROM Food f WHERE f.id = ?1")
    Optional<Food> findByHotel(String hotelId);

    @Query("SELECT f FROM Food f WHERE f.hotelId = ?1")
    List<Food> findByHotelId(String hotelId);

    @Query("SELECT f FROM Food f WHERE f.cuisine = ?1")
    List<Food> findByCuisine(String cuisine);

    @Query("SELECT f FROM Food f WHERE f.availability = ?1")
    List<Food> findByAvailability(boolean availability);

}
