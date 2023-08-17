package com.example.nichefood.services.implementations;

import com.example.nichefood.Configurations.security.JwtService;
import com.example.nichefood.controllers.interfaces.AuthenticationResponse;
import com.example.nichefood.controllers.interfaces.RegisterRequest;
import com.example.nichefood.controllers.interfaces.loginRequest;
import com.example.nichefood.models.Role;
import com.example.nichefood.models.User;
import com.example.nichefood.repositories.UserRepository;
import com.example.nichefood.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .name(request.getName())
                .phone(request.getPhone())
                .address(request.getAddress())
                .createdAt(new Date())
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(loginRequest request) {
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new RuntimeException("User not found")
        );

        // if not authenticated, throws exception without using authenticationManager
        String inputPassword = request.getPassword();
        String userPassword = user.getPassword();
        passwordEncoder.matches(inputPassword, userPassword);
        if (!passwordEncoder.matches(inputPassword, userPassword)) {
            throw new RuntimeException("Wrong password");
        }

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
