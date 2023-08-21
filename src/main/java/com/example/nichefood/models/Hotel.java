package com.example.nichefood.models;

import com.example.nichefood.models.utils.Address;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Data
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "hotels", uniqueConstraints = {
        @UniqueConstraint(columnNames = "hotel_id", name = "uniqueIdConstraint"),
        @UniqueConstraint(columnNames = "hotel_name", name = "uniqueNameConstraint"),
        @UniqueConstraint(columnNames = "email", name = "uniqueEmailConstraint"),
})
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(
            name = "hotel_id",
            columnDefinition = "BINARY(16)",
            nullable = false, updatable = false
    )
    private UUID hotel_id;

    @Column(name = "hotel_name", nullable = false)
    private String hotel_name;

    @Embedded
    private Address address;

    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    private double rating = 0.0;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    private List<String> image;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt = new Date();

    @OneToMany(mappedBy = "hotel_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Food> foodList = new ArrayList<>();

}
