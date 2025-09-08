package com.example.Customer.Repository;

import com.example.Customer.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts,Long> {

    boolean existsByAccountNo(Long accountNo);

}
