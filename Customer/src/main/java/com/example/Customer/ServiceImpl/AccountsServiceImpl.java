package com.example.Customer.ServiceImpl;


import com.example.Customer.Repository.AccountsRepository;
import com.example.Customer.Service.AccountsService;
import com.example.Customer.Service.CustomerService;
import com.example.Customer.entity.Accounts;
import com.example.Customer.entity.Customer;
import com.example.Customer.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {


    private CustomerService customerService;
    private AccountsRepository accountsRepository;
    @Override
    public Accounts createAccount(Long customerId, Accounts accounts) {

        Customer customer = customerService.findCustomer(customerId);
        Long accNo = Long.parseLong(generateAccountNo());
        accounts.setAccountNo(accNo);
        accounts.setIfscCode("ABCRED145YG");
        accounts.setCustomer(customer);
        accounts.setCreatedDt(LocalDateTime.now());
        return accountsRepository.save(accounts);
    }

    private String generateAccountNo() {
        Random random = new Random();
        String accountNo;
        do {
            accountNo = String.valueOf(1000000000L + random.nextLong(9000000000L));
        } while (accountsRepository.existsByAccountNo(Long.parseLong(accountNo)));

        return accountNo;
    }

    @Override
    public Accounts getAccount(Long AccountNo)
    {
        Accounts acc= accountsRepository.findById(AccountNo).orElseThrow(
                ()-> new ResourceNotFoundException("No Account Found with "+AccountNo)
        );
        return acc;
    }

}
