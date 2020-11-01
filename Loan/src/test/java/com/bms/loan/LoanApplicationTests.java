package com.bms.loan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.bms.loan.exception.LoanInsertionFailedException;
import com.bms.customer.model.Customer;
import com.bms.customer.model.Loan;
import com.bms.customer.response.CustomResponse;
import com.bms.loan.controller.LoanController;
import com.bms.loan.repository.LoanRepository;
import com.bms.loan.service.LoanServiceImpl;


/**
 * @author javacloudmc446
 *
 */
@SpringBootTest
class LoanApplicationTests {

	@Mock
	private LoanRepository loanRepository;

	@InjectMocks
	LoanServiceImpl loanService;
	
	@InjectMocks
	LoanController loanController;
	

	@Test
	   void testapplyLoan() throws Exception {
		Customer cust=new Customer(9L);
		final  Loan loan1 = new Loan();
		loan1.setCustomer(cust);
		loan1.setDate("12-8-1998");
		loan1.setLoanAmount(1000000L);
		loan1.setLoanType("personal");
		loan1.setRateOfInterest("3");
		loan1.setDurationOfLoan("36");
			when(loanRepository.save(loan1)).thenReturn(loan1);
		  
		final  Loan loan=loanService.applyLoan(loan1);
		assertThat(loan).isNotNull();
	  }
	
	@Test
	void testapplyLoanFails() throws Exception {
		Assertions.assertThrows(LoanInsertionFailedException.class, () -> {

			final Loan loan1 = new Loan();
			when(loanRepository.save(loan1)).thenReturn(null);

			final Loan loan = loanService.applyLoan(loan1);
			assertThat(loan).isNotNull();
		});
	}
	
	 @Test
		void testBreaker() throws Exception {
		 Customer cust=new Customer(9L);
		  final	Loan loan1 = new Loan(cust,"12-8-1998",1000000L,"personal","3","36");
			when(loanRepository.save(loan1)).thenReturn(loan1);

			final ResponseEntity<CustomResponse> loan = loanController.circuitBreaker(loan1);
			assertThat(loan).isNotNull();
		
		}
	 
	
	 @Test
     void testApplication()
     {
         LoanApplication.main(new String[]{
                 "--spring.main.web-environment=false",
                 "--spring.autoconfigure.exclude=blahblahblah",
                 // Override any other environment properties according to your needs
         });
     }

}
