package com.example.nichefood.repositories;

import com.example.nichefood.models.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryRepo extends JpaRepository<Delivery, UUID> {
}
