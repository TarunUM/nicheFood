package com.example.nichefood.services;

import com.example.nichefood.controllers.interfaces.AuthenticationResponse;
import com.example.nichefood.controllers.interfaces.RegisterRequest;
import com.example.nichefood.controllers.interfaces.loginRequest;

public interface AuthService {

    public AuthenticationResponse register(RegisterRequest request);

    public AuthenticationResponse login(loginRequest request);
}
