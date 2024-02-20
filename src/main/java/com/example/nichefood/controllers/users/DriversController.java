package com.example.nichefood.controllers.users;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.models.users.Drivers;
import com.example.nichefood.services.users.DriversServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/drivers")
public class DriversController {

    private final DriversServices driversService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Drivers>>> getDrivers() {
        return ResponseEntity.ok(driversService.getDrivers());
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<ApiResponse<Drivers>> getDriverById(@PathVariable("id") String id) {
        return ResponseEntity.ok(driversService.getDriverById(id));
    }

    @GetMapping(path = "{email}")
    public ResponseEntity<ApiResponse<Drivers>> getDriverByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(driversService.getDriverByEmail(email));
    }

    @GetMapping(path = "{licenseNumber}")
    public ResponseEntity<ApiResponse<Drivers>> getDriverByLicenseNumber(@PathVariable("licenseNumber") String licenseNumber) {
        return ResponseEntity.ok(driversService.getDriverByLicenseNumber(licenseNumber));
    }

    @GetMapping(path = "{vehicleNumber}")
    public ResponseEntity<ApiResponse<Drivers>> getDriverByVehicleNumber(@PathVariable("vehicleNumber") String vehicleNumber) {
        return ResponseEntity.ok(driversService.getDriverByVehicleNumber(vehicleNumber));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Drivers>> createDriver(@RequestBody Drivers driver) {
        return ResponseEntity.ok(driversService.createDriver(driver));
    }

    @PatchMapping(path = "{id}")
    public ResponseEntity<ApiResponse<Drivers>> updateDriver(@PathVariable("id") String id, @RequestBody Drivers driver) {
        return ResponseEntity.ok(driversService.updateDriver(id, driver));
    }

    @DeleteMapping(path = "{id}")
    public void deleteDriver(@PathVariable("id") String id) {
        driversService.deleteDriver(id);
    }
}
