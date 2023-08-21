package com.example.nichefood.controllers.interfaces.auth;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class loginRequest {
    private String email;
    private String password;

    public loginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
