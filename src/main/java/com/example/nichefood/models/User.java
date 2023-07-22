package com.example.nichefood.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class User {
    private String id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private Date createdAt;

    public User(String email, String password, String name, String phone, String address) {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.createdAt = new Date();
    }
}
