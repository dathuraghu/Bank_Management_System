package com.example.Customer.Service;


import com.example.Customer.entity.Accounts;

public interface AccountsService {
    Accounts createAccount(Long customerId, Accounts accounts);

    Accounts getAccount(Long AccountNo);

}
