package com.example.Customer;


import com.example.Customer.Service.CustomerService;
import com.example.Customer.entity.Customer;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankManagementSystemApplicationTests {

	@Autowired
	CustomerService customerService;

	@Test
	public void createCustomer() {

			Customer customer =new Customer();
			customer.setName("Ram");
			customer.setEmail("ram@gmail.com");
			customer.setPhoneNo("987676");
			Customer customer1=customerService.createCustomer(customer);
			System.out.println(customer1);

	}

	@Test
	public void findCustomer() {
		Customer customer1=customerService.findCustomer(1L);
		System.out.println(customer1);

	}

	@Test
	public void updateCustomer()
	{
		Customer customer =customerService.findCustomer(2L);
		System.out.println("Before Update :"+customer);

		customer.setName("Rahul");
		customer.setEmail("rahul@gmail.com");
		customer.setPhoneNo("0987667");

		Customer cust = customerService.updateCustomer(customer);
		System.out.println("After Update:"+cust);
	}

	@Test
	public void deleteCustomer()
	{
		Customer customer = customerService.deleteCustomer(1L);

		System.out.println(customer);

	}

}
