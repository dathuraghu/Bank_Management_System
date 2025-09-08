package com.example.Loans.Service;

import com.example.Loans.entity.Loans;

public interface LoansService {
    Loans createLoan(Loans loans);
    Loans getLoan(Long loanId);
    Loans updateLoan(Loans loans);
    Loans deleteLoan(Long loanId);
}
