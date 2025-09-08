package com.example.Customer.ServiceImpl;


import com.example.Customer.Repository.CustomerRepository;
import com.example.Customer.Service.CustomerService;
import com.example.Customer.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;


    @Override
    public Customer createCustomer(Customer customer) {
        if(customer!=null)
        {
            customer.setMetaStatus("A");
            customer.setCreatedDt(LocalDateTime.now());
            Customer customer1=customerRepository.save(customer);
            return customer1;
        }
        return null;
    }

    @Override
    public Customer findCustomer(Long customerId)
    {
        return customerRepository.findById(customerId).orElseThrow(
                () -> new RuntimeException("Customer With Given Id Not Found")
        );
    }

    @Override
    public Customer updateCustomer(Customer customer)
    {
        Customer customerFromDb = findCustomer(customer.getCustomerId());

        if(customer.getEmail()!=null) {
            customerFromDb.setEmail(customer.getEmail());
        }
        if(customer.getPhoneNo()!=null) {
            customerFromDb.setPhoneNo(customer.getPhoneNo());
        }
        if(customer.getName()!=null) {
            customerFromDb.setName(customer.getName());
        }
        customerFromDb.setLastUpdatedDt(LocalDateTime.now());

        return customerRepository.save(customerFromDb);
    }

    @Override
    public Customer deleteCustomer(Long customerId) {

        Customer customerFromDb = findCustomer(customerId);

        customerFromDb.setMetaStatus("I");
        customerFromDb.setLastUpdatedDt(LocalDateTime.now());

        return customerRepository.save(customerFromDb);

    }


}
