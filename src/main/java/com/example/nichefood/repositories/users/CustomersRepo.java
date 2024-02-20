package com.example.nichefood.repositories.users;

import com.example.nichefood.models.users.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
import java.util.UUID;

public interface CustomersRepo extends JpaRepository<Customers, UUID> {

    @Query("SELECT c FROM Customers c WHERE c.email = ?1")
    Optional<Customers> findByEmail(String email);
}
