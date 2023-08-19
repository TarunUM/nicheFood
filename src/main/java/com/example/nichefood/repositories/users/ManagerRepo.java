package com.example.nichefood.repositories.users;

import com.example.nichefood.models.users.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManagerRepo extends JpaRepository<Manager, UUID> {
}
