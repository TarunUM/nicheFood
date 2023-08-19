package com.example.nichefood.repositories.users;

import com.example.nichefood.models.users.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DriversRepo extends JpaRepository<Drivers, UUID> {
}
