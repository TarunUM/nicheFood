package com.example.nichefood.models.users;

import com.example.nichefood.models.utils.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Customers {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(
            columnDefinition = "BINARY(16)",
            nullable = false, updatable = false
    )
    private UUID id;

    @OneToOne
    @PrimaryKeyJoinColumn
    @MapsId
    private User customer;
    private String name;
    private String email;
    private String phone;

    @Embedded
    private Address address;

    private boolean isVerified;
    private boolean isBlocked;
    private boolean isDeleted;
}
