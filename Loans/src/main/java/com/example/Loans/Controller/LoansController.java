package com.example.Loans.Controller;

import com.example.Loans.Service.LoansService;
import com.example.Loans.entity.Loans;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/loans")
public class LoansController {

    private final LoansService loansService;


    @PostMapping("/create")
    public ResponseEntity<Loans> createLoan(@RequestBody Loans loans) {
        Loans createdLoan = loansService.createLoan(loans);
        return new ResponseEntity<>(createdLoan, HttpStatus.CREATED);
    }


    @GetMapping("/find/{loanId}")
    public ResponseEntity<Loans> getLoan(@PathVariable Long loanId) {
        Loans loan = loansService.getLoan(loanId);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<Loans> updateLoan(@RequestBody Loans loans) {
        Loans updatedLoan = loansService.updateLoan(loans);
        return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
    }


    @PostMapping("/delete/{loanId}")
    public ResponseEntity<Loans> deleteLoan(@PathVariable Long loanId) {
        Loans loan = loansService.deleteLoan(loanId);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

}
