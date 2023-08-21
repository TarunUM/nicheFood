package com.example.nichefood.repositories.users;

import com.example.nichefood.models.users.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.UUID;

public interface ManagersRepo extends JpaRepository<Manager, UUID> {
}
