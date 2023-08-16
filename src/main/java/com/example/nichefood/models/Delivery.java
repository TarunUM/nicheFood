package com.example.nichefood.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Delivery {
    private String id;
    private String orderId;
    private String driverId;
    private String deliveryStatus;
    private Date deliveryTime;

    public Delivery(String orderId, String driverId, String deliveryStatus, Date deliveryTime) {
        this.id = UUID.randomUUID().toString();
        this.orderId = orderId;
        this.driverId = driverId;
        this.deliveryStatus = deliveryStatus;
        this.deliveryTime = deliveryTime;
    }
}
