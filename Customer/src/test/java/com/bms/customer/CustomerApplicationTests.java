package com.bms.customer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.bms.customer.controller.CustomerController;
import com.bms.customer.exception.CustomerInsertionFailedException;
import com.bms.customer.exception.CustomerNotFoundException;
import com.bms.customer.model.Customer;
import com.bms.customer.model.Loan;
import com.bms.customer.model.Login;
import com.bms.customer.model.RandomNumberGenerator;
import com.bms.customer.repository.CustomerRepository;
import com.bms.customer.response.CustomResponse;
import com.bms.customer.service.CustomerServiceImpl;

/**
 * @author javacloudmc446
 *
 */
@SpringBootTest
class CustomerApplicationTests {

	@Mock
	private CustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl customerService;

	@InjectMocks
	CustomerController customerController;

	@Test
	void testAddCustomer() throws Exception {
		final Customer customer1 = new Customer();
		customer1.setCustId(11L);
		customer1.setName("dekshith");
		customer1.setUserName("dekshith123");
		customer1.setPassword("dee1234");
		customer1.setAddress("196/567");
		customer1.setState("telangana");
		customer1.setCountry("india");
		customer1.setEmailAddress("dgundeti@gmail.com");
		customer1.setPan("ABCDE12345");
		customer1.setContactNo("1234567890");
		customer1.setDob("12-8-1997");
		customer1.setAccountType("savings");
		customer1.setAccountNum(6628261344866053L);
		when(customerRepository.save(customer1)).thenReturn(customer1);

		final Customer customer = customerService.addCustomer(customer1);
		assertThat(customer).isNotNull();
		assertEquals(11L, customer.getCustId());
		assertEquals("dekshith", customer.getName());
		assertEquals("dekshith123", customer.getUserName());
		assertEquals("dee1234", customer.getPassword());
		assertEquals("196/567", customer.getAddress());
		assertEquals("telangana", customer.getState());
		assertEquals("india", customer.getCountry());
		assertEquals("dgundeti@gmail.com", customer.getEmailAddress());
		assertEquals("ABCDE12345", customer.getPan());
		assertEquals("1234567890", customer.getContactNo());
		assertEquals("12-8-1997", customer.getDob());
		assertEquals("savings", customer.getAccountType());
		assertEquals(6628261344866053L, customer.getAccountNum());
	}

	@Test
	void testAddCustomerFails() throws Exception {
		Assertions.assertThrows(CustomerInsertionFailedException.class, () -> {
			final Customer customer1 = new Customer();
			when(customerRepository.save(customer1)).thenReturn(null);

			final Customer customer = customerService.addCustomer(customer1);
			assertThat(customer).isNotNull();
		});
	}
	@Test
	void testCustomerModel() throws Exception {
		 Customer cust=new Customer(9L);
		  final List<Loan> loans= new ArrayList();
		  loans.add(new Loan(cust,"12-8-1998",1000000L,"personal","3","36"));
		  final Customer customer1 = new Customer(11L, "dekshith", "dekshith123", "dee1234", "196/567", "telangana",
					"india", "dgundeti@gmail.com", "ABCDE12345", "1234567890", "12-8-1997", "savings", 6628261344866053L,loans);
		  customer1.setLoans(loans);
		  assertEquals(loans,customer1.getLoans());
	}

	@Test
	void testLoginModel() throws Exception {
		final Login login1 = new Login();
		login1.setUserName("dgundeti");
		login1.setPassword("dee1234");
		assertEquals("dgundeti",login1.getUserName());
		assertEquals("dee1234",login1.getPassword());
	}
	@Test
	void testLoginModel1() throws Exception {
		final Login login1 = new Login("dgundeti","dee1234");
		assertEquals("dgundeti",login1.getUserName());
		assertEquals("dee1234",login1.getPassword());
	}
	@Test
	void testRandomModel() throws Exception {
		final long accountNum =RandomNumberGenerator.random();
		RandomNumberGenerator r= new RandomNumberGenerator();
		assertThat(accountNum).isNotNull();
	}
	
	@Test
	void testLoanModel() throws Exception {
		Customer cust=new Customer(9L);
		final  Loan loan1 = new Loan();
		loan1.setCustomer(cust);
		loan1.setLoanId(1L);
		loan1.setDate("12-8-1998");
		loan1.setLoanAmount(1000000L);
		loan1.setLoanType("personal");
		loan1.setRateOfInterest("3");
		loan1.setDurationOfLoan("36");
		assertEquals(1000000L,loan1.getLoanAmount());
		assertEquals(1L,loan1.getLoanId());
		assertEquals("12-8-1998",loan1.getDate());
		assertEquals(cust,loan1.getCustomer());	
		assertEquals("personal",loan1.getLoanType());
		assertEquals("3",loan1.getRateOfInterest());
		assertEquals("36",loan1.getDurationOfLoan());
		
	}

	@Test
	void testGetCustomerByuserName() throws Exception {
		final String userName = "dekshith123";
		final Customer customer1 = new Customer(11L, "dekshith", "dekshith123", "dee1234", "196/567", "telangana",
				"india", "dgundeti@gmail.com", "ABCDE12345", "1234567890", "12-8-1997", "savings", 6628261344866053L);
		when(customerRepository.findByUserName(userName)).thenReturn(customer1);

		final Customer customer = customerService.getCustomerByuserName(userName);
		assertThat(customer).isNotNull();
	}

	@Test
	void testGetCustomerByuserNameFails() throws Exception {
		Assertions.assertThrows(CustomerNotFoundException.class, () -> {
			final String userName = "dekshith123";
			when(customerRepository.findByUserName(userName)).thenReturn(null);

			final Customer customer = customerService.getCustomerByuserName(userName);
			assertThat(customer).isNotNull();
		});
	}

	@Test
	void testGetAllCustomer() throws Exception {
		final List<Customer> customers = new ArrayList();
		customers.add(new Customer(11L, "dekshith", "dekshith123", "dee1234", "196/567", "telangana", "india",
				"dgundeti@gmail.com", "ABCDE12345", "1234567890", "12-8-1997", "savings", 6628261344866053L));
		customers.add(new Customer(12L, "dekshitha", "dekshitha123", "dee12345", "196/567", "telangana", "india",
				"dgundeti1@gmail.com", "ABCDE12345", "1234567890", "12-8-1997", "savings", 6628261344866054L));
		customers.add(new Customer(13L, "dekshith", "dekshith123", "dee123456", "196/567", "telangana", "india",
				"dgundeti2@gmail.com", "ABCDE12345", "1234567890", "12-8-1997", "savings", 6628261344866055L));
		when(customerRepository.findAll()).thenReturn(customers);

		final List<Customer> customerList = customerService.getAllCustomers();
		assertThat(customerList).isNotNull();
	}

	@Test
	void testGetCustomerById() throws Exception {
		final long custId = 11L;
		final Customer customer1 = new Customer(11L, "dekshith", "dekshith123", "dee1234", "196/567", "telangana",
				"india", "dgundeti@gmail.com", "ABCDE12345", "1234567890", "12-8-1997", "savings", 6628261344866053L);
		when(customerRepository.findById(custId)).thenReturn(Optional.of(customer1));

		final Optional<Customer> customer = customerService.getCustomerById(custId);
		assertThat(customer).isNotNull();
	}

	@Test
	void testGetCustomerByIdFails() throws Exception {
		Assertions.assertThrows(CustomerNotFoundException.class, () -> {
			final long custId = 11L;
			when(customerRepository.findById(custId)).thenReturn(null);

			final Optional<Customer> customer = customerService.getCustomerById(custId);
			assertThat(customer).isNotNull();
		});
	}

	@Test
	void testApplication() {
		CustomerApplication.main(
				new String[] { "--spring.main.web-environment=false", "--spring.autoconfigure.exclude=blahblahblah",
				// Override any other environment properties according to your needs
				});
	}

	 @Test
		void testBreaker1() throws Exception {
		  final	Customer customer1 = new Customer(11L,"dekshith","dekshith123","dee1234","196/567",
					"telangana","india","dgundeti@gmail.com","ABCDE12345","1234567890","12-8-1997","savings",
					6628261344866053L);
			when(customerRepository.save(customer1)).thenReturn(customer1);

			final ResponseEntity<CustomResponse> customer = customerController.circuitBreaker1(customer1);
			assertThat(customer).isNotNull();
		
		}
}
