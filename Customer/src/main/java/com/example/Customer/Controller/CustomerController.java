package com.example.Customer.Controller;



import com.example.Customer.Service.CustomerService;
import com.example.Customer.entity.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer)
    {
        Customer customer1 = customerService.createCustomer(customer);
        return new ResponseEntity<>(customer1,HttpStatus.CREATED);
    }

    @GetMapping("/find/{customerId}")
    public ResponseEntity<Customer> findCustomer(@PathVariable Long customerId)
    {
        Customer customer1 = customerService.findCustomer(customerId);
        return new ResponseEntity<>(customer1,HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer)
    {
        Customer cust= customerService.updateCustomer(customer);
        return new ResponseEntity<>(cust,HttpStatus.OK);
    }

    @PostMapping("/delete/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long customerId)
    {
        Customer customer = customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

}
