package com.bms.update;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.bms.customer.exception.CustomerInsertionFailedException;
import com.bms.customer.model.Customer;
import com.bms.update.controller.UpdateController;
import com.bms.update.repository.UpdateRepository;
import com.bms.customer.response.CustomResponse;
import com.bms.update.service.UpdateServiceImpl;

/**
 * @author javacloudmc446
 *
 */
@SpringBootTest
class UpdateApplicationTests {
	@Mock
	private UpdateRepository updateRepository;

	@InjectMocks
	UpdateServiceImpl updateService;
	
	@InjectMocks
	UpdateController updateController;

	@Test
	void testUpdateCustomer() throws Exception {
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
		when(updateRepository.save(customer1)).thenReturn(customer1);

		final Customer customer = updateService.updateCustomer(customer1);
		assertThat(customer).isNotNull();
		assertEquals(11L, customer.getCustId());
		assertEquals("dekshith", customer.getName());
		assertEquals("dekshith123", customer.getUserName());
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
	void testUpdateCustomerFails() throws Exception {
		Assertions.assertThrows(CustomerInsertionFailedException.class, () -> {

			final Customer customer1 = new Customer();
			when(updateRepository.save(customer1)).thenReturn(null);

			final Customer customer = updateService.updateCustomer(customer1);
			assertThat(customer).isNotNull();
		});
	}

	 @Test
		void testBreaker() throws Exception {
		  final	Customer customer1 = new Customer(11L,"dekshith","dekshith123","dee1234","196/567",
					"telangana","india","dgundeti@gmail.com","ABCDE12345","1234567890","12-8-1997","savings",
					6628261344866053L);
			when(updateRepository.save(customer1)).thenReturn(customer1);

			final ResponseEntity<CustomResponse> customer = updateController.circuitBreaker(customer1);
			assertThat(customer).isNotNull();
		
		}
	 
	  @Test
	    void testApplication()
	    {
	        UpdateApplication.main(new String[]{
	                "--spring.main.web-environment=false",
	                "--spring.autoconfigure.exclude=blahblahblah",
	                // Override any other environment properties according to your needs
	        });
	    }
	  
	 
	 
	  
}
