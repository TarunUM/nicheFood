package com.example.nichefood.models.utils;

import com.example.nichefood.models.Food;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Embeddable
public class OrderedFood {
    @ManyToOne
    private Food food;

    @Column(nullable = false, updatable = false, columnDefinition = "int default 1")
    private short quanntity;
}
