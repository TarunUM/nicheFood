package com.example.nichefood.repositories.users;

import com.example.nichefood.models.users.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.UUID;

public interface CustomersRepo extends JpaRepository<Customers, UUID> {
}
