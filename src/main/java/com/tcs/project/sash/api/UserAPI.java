package com.tcs.project.sash.api;

import java.sql.Date;
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

import com.tcs.project.sash.model.Address;
import com.tcs.project.sash.model.Customer;
import com.tcs.project.sash.services.BankingCURDService;

@RestController
@RequestMapping("sash/users")
public class UserAPI
{
	@Autowired
	private BankingCURDService userService;

	@GetMapping("user/id/{id}")
	public ResponseEntity<Customer> getUserByID(@PathVariable("id") String id)
	{
		Customer obj = userService.findCustomerByID(id);
		if(obj != null)
			return new ResponseEntity<Customer> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<Customer> (new Customer(), HttpStatus.OK);
	}
	
	@GetMapping("user/name/{name}")
	public ResponseEntity<List<Customer>> getUserByName(@PathVariable("name") String name)
	{
		List<Customer> obj = userService.getCustomerByName(name);
		
		if(obj != null)
			return new ResponseEntity<List<Customer>> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<List<Customer>> (new ArrayList<Customer>(), HttpStatus.OK);
	}
	
	@PostMapping("user")
	public ResponseEntity<Customer> addUser(@RequestBody Customer customer)	
	{
		Customer obj = userService.addCustomer(customer);
		if(obj != null)
			return new ResponseEntity<Customer>(obj, HttpStatus.OK);
		else
			return new ResponseEntity<Customer>(new Customer(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("user")
	public ResponseEntity<Customer> getUser()	
	{
		return new ResponseEntity<Customer> (new Customer("U-003", "342167543287", "Shruti", new Address("A-103","65-C","lakshmi nagar","delhi", "delhi", 110126), new Date(21, 6, 1998),"9843661776", "999920145", "shruti.united@gmail.com"), HttpStatus.OK);
	}

	@GetMapping("all")
	public ResponseEntity<List<Customer>> getAllUser()	
	{
		return new ResponseEntity<List<Customer>> (userService.getAllCustomers(), HttpStatus.OK);
	}
}
