package com.ds.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.springdemo.entity.Customer;
import com.ds.springdemo.exception.CustomerNotFoundException;
import com.ds.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")//Get List
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")//Get Single
	public Customer getCustomer(@PathVariable int customerId){
		
		Customer customer = customerService.getCustomer(customerId);
		
		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found = " + customerId);
		}
		
		return customer;
	}
	
	@PostMapping("/customers")//Add
	public Customer addCustomer(@RequestBody Customer customer){
		
		customer.setId(0);
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@PutMapping("/customers")//Update
	public Customer updateCustomer(@RequestBody Customer customer){
		
		customerService.saveCustomer(customer);
		
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")//Delete
	public String deleteCustomer(@PathVariable int customerId){
		
		Customer customer = customerService.getCustomer(customerId);
		
		if(customer == null) {
			throw new CustomerNotFoundException("Customer id not found = " + customerId);
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted Customer id= " + customerId;
	}
}
