package com.example.Loans;

import com.example.Loans.Service.LoansService;
import com.example.Loans.entity.Loans;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LoansApplicationTests {

	@Autowired
	private LoansService loansService;

	@Test
	public void createLoan()
	{
		Loans loans =new Loans();
		loans.setCustomerId(1L);
		loans.setLoanAmount(7679.34);
		loans.setTenureInMonths(2);
		loans.setInterestRate(5.5f);

		loansService.createLoan(loans);
		System.out.println(loans);

	}

	@Test
	public void getLoan()
	{
		Loans loans = loansService.getLoan(1L);
		System.out.println(loans);

	}

	@Test
	public void updateLoan()
	{
		Loans loans = loansService.getLoan(1L);
		loans.setLoanAmount(98999.78);
		Loans loans1=loansService.updateLoan(loans);
		System.out.println(loans1);

	}

	@Test
	public void deleteLoan()
	{
		 System.out.println(loansService.deleteLoan(2L));
	}

}
