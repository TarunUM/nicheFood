package com.example.nichefood.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "food")
@AllArgsConstructor
public class Food {
    @Id
    @Column(name = "food_id", nullable = false,
            updatable = false, unique = true,
            columnDefinition = "BINARY(16)")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "hotel_id", nullable = false,
            referencedColumnName = "hotel_id",
            foreignKey = @ForeignKey(name = "fk_hotel_id"),
            columnDefinition = "BINARY(16)")
    private Hotel hotel;

    @Column(name = "name", nullable = false)
    private String name;

    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "cuisine", nullable = false)
    private String cuisine;

    @Column(name = "ingredients", nullable = false)
    private String ingredients;

    @Lob
    private List<String> image;

    @Column(name = "availability", nullable = false, columnDefinition = "boolean default true")
    private boolean availability;
}
