package com.example.nichefood.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Hotel {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private float rating;
    private String description;
    private String[] image;
    private Date createdAt;

    public Hotel(String name, String address, String phone, String email, float rating, String description, String[] image) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.rating = rating;
        this.description = description;
        this.image = image;
        this.createdAt = new Date();
    }
}
