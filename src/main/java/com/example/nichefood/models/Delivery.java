package com.example.nichefood.models;

import com.example.nichefood.models.users.Drivers;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Delivery {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private FoodOrders orderId;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Drivers driverId;

    @Column(nullable = false)
    private String deliveryStatus;

    private Date deliveryTime;

    private enum Status{
        PickUp,
        Delivering,
        Delivered
    }
}
