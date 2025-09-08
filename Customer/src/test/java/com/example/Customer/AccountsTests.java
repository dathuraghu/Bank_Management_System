package com.example.Customer;


import com.example.Customer.Service.AccountsService;
import com.example.Customer.entity.Accounts;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@AllArgsConstructor
public class AccountsTests {

    @Autowired
    private AccountsService accountsService;

    @Test
    public void createAccount()
    {
        Accounts accounts = new Accounts();

        accountsService.createAccount(1L,accounts);

        System.out.println(accounts);

    }

    @Test
    public void getAccount()
    {
        Accounts acc = accountsService.getAccount(4104875434L);
        System.out.println(acc);

    }

}
