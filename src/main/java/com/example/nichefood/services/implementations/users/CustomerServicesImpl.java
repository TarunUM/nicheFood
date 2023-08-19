package com.example.nichefood.services.implementations.users;

import com.example.nichefood.Configurations.security.JwtService;
import com.example.nichefood.controllers.interfaces.AuthenticationResponse;
import com.example.nichefood.controllers.interfaces.RegisterRequest;
import com.example.nichefood.controllers.interfaces.loginRequest;
import com.example.nichefood.models.enums.Role;
import com.example.nichefood.models.users.User;
import com.example.nichefood.repositories.users.UserRepository;
import com.example.nichefood.services.users.AuthService;
import com.example.nichefood.services.users.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerServicesImpl implements CustomerServices {

}
