package com.example.nichefood.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;

    public RegisterRequest(String email, String password, String name, String phone, String address) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
