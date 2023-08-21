package com.example.nichefood.models.users;

import com.example.nichefood.models.utils.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Drivers {
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
    private User driver;

    private String name;
    private String email;
    private String phone;
    private String licenseNumber;
    private String vehicleNumber;
    private boolean availability;
    @Embedded
    private Address address;
}
