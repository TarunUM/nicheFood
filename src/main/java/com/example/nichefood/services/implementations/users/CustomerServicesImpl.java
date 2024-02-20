package com.example.nichefood.services.implementations.users;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.exceptions.GeneralExceptions;
import com.example.nichefood.models.users.Customers;
import com.example.nichefood.repositories.users.CustomersRepo;
import com.example.nichefood.services.users.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerServicesImpl implements CustomerServices {

    private final CustomersRepo customersRepo;

    @Override
    public ApiResponse<List<Customers>> getCustomers() {
        List<Customers> customers = customersRepo.findAll();
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Customers fetched successfully", customers.size(), customers);
    }

    @Override
    public ApiResponse<Customers> getCustomerById(String id) {
        Customers customer = customersRepo.findById(UUID.fromString(id)).orElseThrow(
                () -> new GeneralExceptions("Customer not found")
        );
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Customer fetched successfully", 1, customer);
    }

    @Override
    public ApiResponse<Customers> addCustomer(Customers customer) {
        customersRepo.save(customer);
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Customer added successfully", 1, customer);
    }

    @Override
    public ApiResponse<Customers> updateCustomer(String id, Customers newCustomer) {
        Customers customers = customersRepo.findById(UUID.fromString(id)).orElseThrow(
                () -> new GeneralExceptions("Customer not found")
        );

        if (newCustomer.getName() != null && !newCustomer.getName().isEmpty() && !newCustomer.getName().equals(customers.getName())) {
            customers.setName(newCustomer.getName());
        }
        if (newCustomer.getEmail() != null && !newCustomer.getEmail().isEmpty() && !newCustomer.getEmail().equals(customers.getEmail())) {
            customers.setEmail(newCustomer.getEmail());
        }

        if (newCustomer.getPhone() != null && !newCustomer.getPhone().isEmpty() && !newCustomer.getPhone().equals(customers.getPhone())) {
            customers.setPhone(newCustomer.getPhone());
        }

        if (newCustomer.getAddress() != null && !newCustomer.getAddress().equals(customers.getAddress())) {
            customers.setAddress(newCustomer.getAddress());
        }

        customers = customersRepo.save(customers);

        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Customer updated successfully", 1, customers);
    }

    @Override
    public void deleteCustomer(String id) {
        try{
            if (!customersRepo.existsById(UUID.fromString(id))) {
                throw new GeneralExceptions("Customer not found");
            }
            customersRepo.deleteById(UUID.fromString(id));
        } catch (Exception e) {
            throw new GeneralExceptions("Error while deleting customer");
        }
    }

    @Override
    public ApiResponse<Customers> getCustomerByEmail(String email) {
        Customers customers = customersRepo.findByEmail(email).orElseThrow(
                () -> new GeneralExceptions("Customer not found")
        );
        return new ApiResponse<>(HttpStatus.OK, Instant.now(), "Customer fetched successfully", 1, customers);
    }
}
