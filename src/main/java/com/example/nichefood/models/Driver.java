package com.example.nichefood.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Driver {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String licenseNumber;
    private String vehicleNumber;
    private boolean availability;
    private Date createdAt;

    public Driver(String name, String email, String phone, String licenseNumber, String vehicleNumber, boolean availability) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
        this.vehicleNumber = vehicleNumber;
        this.availability = availability;
        this.createdAt = new Date();
    }
}
