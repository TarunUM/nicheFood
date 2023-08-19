package com.example.nichefood.repositories.users;

import com.example.nichefood.models.users.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepo extends JpaRepository<Customers, UUID> {
}
