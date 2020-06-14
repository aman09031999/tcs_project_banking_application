package com.tcs.project.sash.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.project.sash.model.Customer;
import com.tcs.project.sash.services.CustomerService;

@RestController
@RequestMapping("sash/customers")
public class UserAPI
{
	@Autowired
	private CustomerService userService;

	@GetMapping("customer/id/{id}")
	public ResponseEntity<Customer> displayCustomerByID(@PathVariable("id") String id)
	{
		Customer obj = userService.findCustomerByID(id);
		if(obj != null)
			return new ResponseEntity<Customer> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<Customer> (new Customer(), HttpStatus.OK);
	}
	
	@GetMapping("customer/name/{name}")
	public ResponseEntity<List<Customer>> displayCustomerByName(@PathVariable("name") String name)
	{
		List<Customer> obj = userService.getCustomerByName(name);
		
		if(obj != null)
			return new ResponseEntity<List<Customer>> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<List<Customer>> (new ArrayList<Customer>(), HttpStatus.OK);
	}
	
	@PostMapping("customer")
	public ResponseEntity<Customer> addNewCustomer(@RequestBody Customer customer)	
	{
		Customer obj = userService.addCustomer(customer);
		if(obj != null)
			return new ResponseEntity<Customer>(obj, HttpStatus.OK);
		else
			return new ResponseEntity<Customer>(new Customer(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("customer")
	public ResponseEntity<List<Customer>> displayAllCustomers()	
	{
		List<Customer> list = userService.getAllCustomers();
		if(list != null)
			return new ResponseEntity<List<Customer>> (list, HttpStatus.OK);
		else
			return new ResponseEntity<List<Customer>> (new ArrayList<>(), HttpStatus.NOT_FOUND);
	}
}
