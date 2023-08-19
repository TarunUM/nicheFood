package com.example.nichefood.repositories;

import com.example.nichefood.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRepository
        extends JpaRepository<Hotel, UUID> {
}
