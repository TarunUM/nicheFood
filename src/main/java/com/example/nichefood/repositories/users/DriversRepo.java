package com.example.nichefood.repositories.users;

import com.example.nichefood.models.users.Drivers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface DriversRepo extends JpaRepository<Drivers, UUID> {

    @Query("SELECT d FROM Drivers d WHERE d.email = ?1")
    Optional<Drivers> findByEmail(String email);

    @Query("SELECT d FROM Drivers d WHERE d.licenseNumber = ?1")
    Optional<Drivers> findByLicenseNumber(String licenseNumber);

    @Query("SELECT d FROM Drivers d WHERE d.vehicleNumber = ?1")
    Optional<Drivers> findByVehicleNumber(String vehicleNumber);

}
