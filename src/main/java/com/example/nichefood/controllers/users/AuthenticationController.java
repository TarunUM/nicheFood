package com.example.nichefood.controllers.users;

import com.example.nichefood.controllers.interfaces.auth.AuthenticationResponse;
import com.example.nichefood.controllers.interfaces.auth.RegisterRequest;
import com.example.nichefood.controllers.interfaces.auth.loginRequest;
import com.example.nichefood.services.implementations.users.AuthServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthServiceImpl authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request,
            HttpServletResponse response
    ) {
        // todo: implement register
        var jwt = authService.register(request);
        String token = jwt.getToken();

        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);

        response.addCookie(cookie);
        return ResponseEntity.ok(jwt);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody loginRequest request,
            HttpServletResponse response
    ) {
        // todo: implement login
        var jwt = authService.login(request);
        String token = jwt.getToken();

        Cookie cookie = new Cookie("jwt", token);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);

        response.addCookie(cookie);
        return ResponseEntity.ok(jwt);
    }

}
