package com.example.nichefood.models.users;

import com.example.nichefood.models.Hotel;
import com.example.nichefood.models.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Manager {
    @Id
    @OneToOne
    private User manager;
    private String name;
    private String email;
    private String phone;

    @ManyToOne
    private Hotel hotel;
}
