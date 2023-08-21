package com.example.nichefood.services.users;

import com.example.nichefood.controllers.interfaces.auth.AuthenticationResponse;
import com.example.nichefood.controllers.interfaces.auth.RegisterRequest;
import com.example.nichefood.controllers.interfaces.auth.loginRequest;

public interface AuthService {

    public AuthenticationResponse register(RegisterRequest request);

    public AuthenticationResponse login(loginRequest request);
}
