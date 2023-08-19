package com.example.nichefood.controllers.interfaces;

import com.example.nichefood.models.utils.Address;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    private Address address;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}
