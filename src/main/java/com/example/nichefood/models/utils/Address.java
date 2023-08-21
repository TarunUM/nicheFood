package com.example.nichefood.models.utils;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
