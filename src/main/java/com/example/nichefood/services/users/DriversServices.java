package com.example.nichefood.services.users;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.models.users.Drivers;

import java.util.List;
import java.util.UUID;

public interface DriversServices {

    ApiResponse<List<Drivers>> getDrivers();

    ApiResponse<Drivers> getDriverById(String id);

    ApiResponse<Drivers> getDriverByEmail(String email);

    ApiResponse<Drivers> getDriverByLicenseNumber(String licenseNumber);

    ApiResponse<Drivers> getDriverByVehicleNumber(String vehicleNumber);

    ApiResponse<Drivers> createDriver(Drivers driver);

    ApiResponse<Drivers> updateDriver(String id, Drivers driver);

    void deleteDriver(String id);

}
