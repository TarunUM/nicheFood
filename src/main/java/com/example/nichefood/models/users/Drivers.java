package com.example.nichefood.models.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Drivers {
    @Id
    @OneToOne
    private User driver;
    private String name;
    private String email;
    private String phone;
    private String licenseNumber;
    private String vehicleNumber;
    private boolean availability;
}
