package com.example.nichefood.repositories;

import com.example.nichefood.models.FoodOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodOrdersRepo extends JpaRepository<FoodOrders, UUID> {

}
