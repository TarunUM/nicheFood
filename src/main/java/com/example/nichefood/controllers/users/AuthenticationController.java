package com.example.nichefood.controllers.users;

import com.example.nichefood.controllers.interfaces.AuthenticationResponse;
import com.example.nichefood.controllers.interfaces.RegisterRequest;
import com.example.nichefood.controllers.interfaces.loginRequest;
import com.example.nichefood.services.implementations.users.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthServiceImpl authService;

    @GetMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        // todo: implement register
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody loginRequest request
    ) {
        // todo: implement login
        return ResponseEntity.ok(authService.login(request));
    }

}
