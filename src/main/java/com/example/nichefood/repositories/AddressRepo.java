package com.example.nichefood.repositories;

import com.example.nichefood.models.utils.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepo
        extends JpaRepository<Address, UUID> {
}
