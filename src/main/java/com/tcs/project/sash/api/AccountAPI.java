package com.tcs.project.sash.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.project.sash.model.Account;
import com.tcs.project.sash.model.AccountType;
//import com.tcs.project.sash.model.Transaction;
import com.tcs.project.sash.services.BankingOtherService;

@RestController
@RequestMapping("sash/accounts")
public class AccountAPI
{
	@Autowired
	private BankingOtherService services;
	
	@PostMapping("account/{customer_id}/current/{amount}")
	public ResponseEntity<Account> addMoneyToCurrentAccount(@PathVariable("customer_id") String customer_id, @PathVariable("amount") double amount)
	{
		Account obj = services.addNewAccount(services.getCustomerById(customer_id), AccountType.current, amount);
		
		if(obj != null)
			return new ResponseEntity<Account> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<Account> (new Account(), HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("account/{customer_id}/saving/{amount}")
	public ResponseEntity<Account> addMoneyToSavingAccount(@PathVariable("customer_id") String customer_id, @PathVariable("amount") double amount)
	{
		Account obj = services.addNewAccount(services.getCustomerById(customer_id), AccountType.saving, amount);
		
		if(obj != null)
			return new ResponseEntity<Account> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<Account> (new Account(), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("account/{account_id}/all")
	public ResponseEntity<List<Account>> displayCustomerAccount(@PathVariable("account_id") String id)
	{
		List<Account> obj = services.getCustomersAllAccounts(id);
		
		if(obj != null)
			return new ResponseEntity<List<Account>> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<List<Account>> (new ArrayList<Account>(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("account")
	public ResponseEntity<List<Account>> displayAllAccounts()
	{
		List<Account> obj = services.getAllAccounts();
		
		if(obj != null)
			return new ResponseEntity<List<Account>> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<List<Account>> (new ArrayList<Account>(), HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("account/saving")
	public ResponseEntity<List<Account>> displayAllSavingAccounts()
	{
		List<Account> obj = services.getAllSavingAccounts();
		
		if(obj != null)
			return new ResponseEntity<List<Account>> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<List<Account>> (new ArrayList<Account>(), HttpStatus.NOT_FOUND);
	}

	@GetMapping("account/current")
	public ResponseEntity<List<Account>> displayAllCurrentAccounts()
	{
		List<Account> obj = services.getAllCurrentAccounts();

		if(obj != null)
			return new ResponseEntity<List<Account>> (obj, HttpStatus.OK);
		else
			return new ResponseEntity<List<Account>> (new ArrayList<Account>(), HttpStatus.NOT_FOUND);
	}
	

	@GetMapping("account/transaction/savings-to-current/{customer_id}/{amount}")
	public ResponseEntity<String> executeTransactionFromSavingToCurrent(@PathVariable("customer_id") String customer_id,
																			@PathVariable("amount") double amount)
	{
		return new ResponseEntity<String> (services.transferMoney(customer_id, AccountType.saving, AccountType.current, amount), HttpStatus.OK);
	}
	
	@GetMapping("account/transaction/current-to-savings/{customer_id}/{amount}")
	public ResponseEntity<String> executeTransactionFromCurrentToSaving(@PathVariable("customer_id") String customer_id,
																			@PathVariable("amount") double amount)
	{
		return new ResponseEntity<String> (services.transferMoney(customer_id, AccountType.current, AccountType.saving, amount), HttpStatus.OK);
	}
}
