package com.example.Customer.Service;


import com.example.Customer.entity.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer findCustomer(Long customerId);

    Customer updateCustomer(Customer customer);

    Customer deleteCustomer(Long customerId);
}
