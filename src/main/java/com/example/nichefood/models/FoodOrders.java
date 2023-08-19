package com.example.nichefood.models;

import com.example.nichefood.models.users.Customers;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class FoodOrders {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)",
            nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @Column(nullable = false, updatable = false, columnDefinition = "int default 1")
    private int quantity;

    @Column(nullable = false, updatable = false)
    private float totalPrice;

    // default order status is PENDING
    @Enumerated(EnumType.STRING)
    private Status orderStatus = Status.PENDING;

    @Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date orderTime;
    private enum Status{
        PENDING,
        ACCEPTED,
        REJECTED,
        DELIVERING,
        DELIVERED
    }
}

