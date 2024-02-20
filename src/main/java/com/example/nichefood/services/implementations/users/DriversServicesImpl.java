package com.example.nichefood.services.implementations.users;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.exceptions.GeneralExceptions;
import com.example.nichefood.models.users.Customers;
import com.example.nichefood.models.users.Drivers;
import com.example.nichefood.repositories.users.DriversRepo;
import com.example.nichefood.services.users.CustomerServices;
import com.example.nichefood.services.users.DriversServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class DriversServicesImpl implements DriversServices {

    private final DriversRepo driversRepo;

    @Override
    public ApiResponse<List<Drivers>> getDrivers() {
        List<Drivers> drivers = driversRepo.findAll();
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Drivers fetched successfully", drivers.size(), drivers);
    }

    @Override
    public ApiResponse<Drivers> getDriverById(String id) {
        Drivers drivers = driversRepo.findById(UUID.fromString(id)).orElseThrow(
                () -> new RuntimeException("Driver not found")
        );
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Driver fetched successfully", 1, drivers);
    }

    @Override
    public ApiResponse<Drivers> getDriverByEmail(String email) {
        Drivers drivers = driversRepo.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Driver not found")
        );
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Driver fetched successfully", 1, drivers);
    }

    @Override
    public ApiResponse<Drivers> getDriverByLicenseNumber(String licenseNumber) {
        Drivers drivers = driversRepo.findByLicenseNumber(licenseNumber).orElseThrow(
                () -> new RuntimeException("Driver not found")
        );
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Driver fetched successfully", 1, drivers);
    }

    @Override
    public ApiResponse<Drivers> getDriverByVehicleNumber(String vehicleNumber) {
        Drivers drivers = driversRepo.findByVehicleNumber(vehicleNumber).orElseThrow(
                () -> new RuntimeException("Driver not found")
        );
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Driver fetched successfully", 1, drivers);
    }

    @Override
    public ApiResponse<Drivers> createDriver(Drivers driver) {
        Drivers drivers = driversRepo.save(driver);
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Driver created successfully", 1, drivers);
    }

    @Override
    public ApiResponse<Drivers> updateDriver(String id, Drivers driver) {
        Drivers oldDriver = driversRepo.findById(UUID.fromString(id)).orElseThrow(
                () -> new RuntimeException("Driver not found")
        );

        if (driver.getName() != null && !driver.getName().isEmpty() && !driver.getName().equals(oldDriver.getName())) {
            oldDriver.setName(driver.getName());
        }
        if (driver.getEmail() != null && !driver.getEmail().isEmpty() && !driver.getEmail().equals(oldDriver.getEmail())) {
            oldDriver.setEmail(driver.getEmail());
        }
        if (driver.getPhone() != null && !driver.getPhone().isEmpty() && !driver.getPhone().equals(oldDriver.getPhone())) {
            oldDriver.setPhone(driver.getPhone());
        }
        if (driver.getLicenseNumber() != null && !driver.getLicenseNumber().isEmpty() && !driver.getLicenseNumber().equals(oldDriver.getLicenseNumber())) {
            oldDriver.setLicenseNumber(driver.getLicenseNumber());
        }
        if (driver.getVehicleNumber() != null && !driver.getVehicleNumber().isEmpty() && !driver.getVehicleNumber().equals(oldDriver.getVehicleNumber())) {
            oldDriver.setVehicleNumber(driver.getVehicleNumber());
        }
        if (driver.isAvailability() != oldDriver.isAvailability()) {
            oldDriver.setAvailability(driver.isAvailability());
        }
        if (driver.getAddress() != null && !driver.getAddress().equals(oldDriver.getAddress())) {
            oldDriver.setAddress(driver.getAddress());
        }

        Drivers newDriver = driversRepo.save(oldDriver);

        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Driver updated successfully", 1, newDriver);
    }

    @Override
    public void deleteDriver(String id) {
        try {
            if (!driversRepo.existsById(UUID.fromString(id))) {
                throw new GeneralExceptions("Driver not found");
            }
            driversRepo.deleteById(UUID.fromString(id));
        } catch (Exception e) {
            throw new GeneralExceptions("Error while deleting driver");
        }
    }
}
