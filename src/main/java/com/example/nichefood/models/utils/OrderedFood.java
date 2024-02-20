package com.example.nichefood.models.utils;

import com.example.nichefood.models.Food;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

@Embeddable
public class foods {
    @ManyToOne
    private Food food;
    private short quanntity;
}
