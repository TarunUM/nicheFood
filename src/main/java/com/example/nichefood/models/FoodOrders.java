package com.example.nichefood.models;

import com.example.nichefood.models.users.Customers;
import com.example.nichefood.models.utils.OrderedFood;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
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

    @Embedded
    private OrderedFood[] foods;

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

