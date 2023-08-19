package com.example.nichefood.models.users;

import com.example.nichefood.models.utils.Address;
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
public class Customers {
    @Id
    @OneToOne
    private User customer;
    private String name;
    private String email;
    private String phone;

    @ManyToOne
    private Address address;

    private boolean isVerified;
    private boolean isBlocked;
    private boolean isDeleted;
}
