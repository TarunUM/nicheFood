package com.example.nichefood.controllers.users;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.controllers.interfaces.auth.AuthenticationResponse;
import com.example.nichefood.controllers.interfaces.auth.RegisterRequest;
import com.example.nichefood.controllers.interfaces.auth.loginRequest;
import com.example.nichefood.models.users.User;
import com.example.nichefood.services.implementations.users.AuthServiceImpl;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RequestMapping("/api/v1/auth")
@RestController
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/authenticated")
    public ResponseEntity<ApiResponse<Object>> user(){
        User authentication = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return ResponseEntity.ok(new ApiResponse<>(
                HttpStatus.OK, Instant.now(), "user fetched", 1, authentication
        ));
    }

}
