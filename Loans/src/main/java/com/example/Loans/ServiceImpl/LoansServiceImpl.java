package com.example.Loans.ServiceImpl;

import com.example.Loans.Repository.LoansRepository;
import com.example.Loans.Service.LoansService;
import com.example.Loans.entity.Loans;
import com.example.Loans.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class LoansServiceImpl implements LoansService {

    private LoansRepository loansRepository;

    @Override
    public Loans createLoan(Loans loans) {
        if(loans!=null)
        {
            loans.setLoanStatus("A");
            loans.setCreatedDt(LocalDateTime.now());
            return loansRepository.save(loans);
        }
        return null;
    }

    @Override
    public Loans getLoan(Long loanId) {
        return loansRepository.findById(loanId)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id " + loanId));
    }


    @Override
    public Loans updateLoan(Loans loans) {
       Loans loansFromDb = getLoan(loans.getLoanId());
       if(loans.getLoanAmount()!=null)
       {
           loansFromDb.setLoanAmount(loans.getLoanAmount());
       }
        if(loans.getInterestRate()!=null)
        {
            loansFromDb.setInterestRate(loans.getInterestRate());
        }
        if(loans.getTenureInMonths()!=null)
        {
            loansFromDb.setTenureInMonths(loans.getTenureInMonths());
        }
        loansFromDb.setLastUpdatedDt(LocalDateTime.now());

       return loansRepository.save(loansFromDb);

    }

    @Override
    public Loans deleteLoan(Long loanId) {
        Loans loans = getLoan(loanId);
        loans.setLoanStatus("I");
        loans.setLastUpdatedDt(LocalDateTime.now());
        return loansRepository.save(loans);
    }
}
