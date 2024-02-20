package com.example.nichefood.controllers.users;

import com.example.nichefood.controllers.interfaces.ApiResponse;
import com.example.nichefood.models.users.Customers;
import com.example.nichefood.services.users.CustomerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/customers")
public class CustomerController {

    private final CustomerServices customerServices;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Customers>>> getCustomers() {
        return ResponseEntity.ok(customerServices.getCustomers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Customers>> getCustomerById(@PathVariable String id) {
        System.out.println(id);
        return ResponseEntity.ok(customerServices.getCustomerById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse<Customers>> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(customerServices.getCustomerByEmail(email));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Customers>> addCustomer(@RequestBody Customers customers){
        return ResponseEntity.ok(customerServices.addCustomer(customers));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<Customers>> updateCustomer(@PathVariable String id, @RequestBody Customers customer){
        return ResponseEntity.ok(customerServices.updateCustomer(id, customer));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerServices.deleteCustomer(id);
    }

}
