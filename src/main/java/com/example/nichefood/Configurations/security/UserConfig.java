package com.example.nichefood.Configurations.security;

import com.example.nichefood.controllers.RegisterRequest;
import com.example.nichefood.models.Role;
import com.example.nichefood.models.User;
import com.example.nichefood.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder){
        System.out.println("UserConfigurations");
        return args -> {
            RegisterRequest user1 = new RegisterRequest(
                    "admin@example.com",
                    "test1234",
                    "Admin",
                    "1234567890",
                    "123 Main St, City"
            );

            RegisterRequest user2 = new RegisterRequest(
                    "tarun@example.com",
                    "test1234",
                    "Tarun",
                    "1234567890",
                    "123 Main St, City"
            );

            RegisterRequest user3 = new RegisterRequest(
                    "user@example.com",
                    "test1234",
                    "User",
                    "1234567890",
                    "123 Main St, City"
            );

            for (RegisterRequest user : List.of(user1, user2, user3)){
                var newUser = User.builder()
                                .id(UUID.randomUUID().toString())
                                .email(user.getEmail())
                                .password(passwordEncoder.encode(user.getPassword()))
                                .role(Role.USER)
                                .name(user.getName())
                                .phone(user.getPhone())
                                .address(user.getAddress())
                                .createdAt(new Date())
                                .build();



                userRepository.save(newUser);
            }
        };
    }
}