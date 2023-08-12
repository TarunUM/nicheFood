package com.example.nichefood.controllers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
