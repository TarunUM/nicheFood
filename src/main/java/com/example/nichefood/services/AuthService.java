package com.example.nichefood.services;

import com.example.nichefood.controllers.AuthenticationResponse;
import com.example.nichefood.controllers.RegisterRequest;
import com.example.nichefood.controllers.loginRequest;

public interface AuthService {

    public AuthenticationResponse register(RegisterRequest request);

    public AuthenticationResponse login(loginRequest request);
}
