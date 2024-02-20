package com.example.nichefood.services.users;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.models.users.Customers;

import java.util.List;

public interface CustomerServices {

    ApiResponse<List<Customers>> getCustomers();

    ApiResponse<Customers> getCustomerById(String id);

    ApiResponse<Customers> addCustomer(Customers customer);

    ApiResponse<Customers> updateCustomer(String id, Customers customer);

    void deleteCustomer(String id);

    ApiResponse<Customers> getCustomerByEmail(String email);
}
