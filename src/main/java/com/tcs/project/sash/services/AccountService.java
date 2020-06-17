package com.tcs.project.sash.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.project.sash.model.Account;
import com.tcs.project.sash.model.AccountOperation;
import com.tcs.project.sash.model.AccountType;
import com.tcs.project.sash.model.Customer;
import com.tcs.project.sash.model.Status;
import com.tcs.project.sash.model.Transaction;
import com.tcs.project.sash.repository.AccountRepository;
import com.tcs.project.sash.repository.CustomerRepository;
import com.tcs.project.sash.repository.TransactionRepository;

@Service
public class AccountService implements AccountServiceInterface
{
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private TransactionRepository txRepo;
	
	@Override
	public String depositMoney(String id, AccountType type, double amount, String message)
	{	
		if(accountRepo.existsById(id))
		{
			System.out.println("Details Entered : [" + id + ", " + type + ", " + amount + "]");
			Account account = accountRepo.findByAccountId(id);
			System.out.println("Account Details [Before] : " + account);
			account.setAmount(account.getAmount() + amount);
			account.setMessage(message);
			account.setLast_updated(new Date());
			account.setLast_operation(AccountOperation.credited);
			
			System.out.println("Account Details [After] : " + accountRepo.getOne(id));
			
			String tx_id = "TX-100" + (txRepo.count() + 1);
			txRepo.save(new Transaction(tx_id, new Date(), account.getCustomerId().getCustomer_id(), type, AccountType.self, amount));
			
			return "Money Deposited Successfully...!!!";
		}
		
		return "Failed to Add Money";
	}
	
	@Override
	public String withdrawMoney(String id, AccountType type, double amount, String message)
	{	
		if(accountRepo.existsById(id))
		{
			Account account = accountRepo.findByAccountId(id);
			
			if(account.getAmount()>amount)
			{
				account.setAmount(account.getAmount() - amount);
				account.setMessage(message);
				account.setLast_operation(AccountOperation.debited);
				account.setLast_updated(new Date());
				
				String tx_id = "TX-100" + (txRepo.count() + 1);
				txRepo.save(new Transaction(tx_id, new Date(), account.getCustomerId().getCustomer_id(), type, AccountType.self, amount));
				
				return "Money Withdraw Successfully...!!!";
			}
			
			return "insufficent balance";
		}
		
		return "Failed to Add Money";
	}
	
	
	@Override
	public Boolean loginUser(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNewAccount(Customer customer, AccountType type, double baseAmount, String message)
	{
		message = "new account is created";
		if(customerRepo.existsById(customer.getCustomer_id()))
		{	
			String account_id = "ACC-100" + (accountRepo.count() + 1);
			Account account = new Account(account_id, type, customer, new Date(), baseAmount, Status.active, "new account is created", AccountOperation.created, new Date() );
		
			accountRepo.save(account);
			
			return "Account with ID : " + account_id + " is created for Customer ID : " + customer.getCustomer_id();
		}
		
		return "Customer ID : " + customer.getCustomer_id() + " failed to created";
	}

	public Customer getCustomerById(String id)
	{
		if(customerRepo.existsById(id))
			return customerRepo.getOne(id);
		
		return new Customer();
	}
	
	public List<Account> getAllAccounts()
	{
		if(accountRepo.findAll() != null)
			return accountRepo.findAll();

		return new ArrayList<Account>();
	}
	
	public List<Account> getAllCurrentAccounts()
	{
		List<Account> list = accountRepo.findByAccountType(AccountType.current);

		if(list != null)
			return list;		

		return new ArrayList<Account>();
	}
	
	public List<Account> getAllSavingAccounts()
	{
		List<Account> list = accountRepo.findByAccountType(AccountType.saving);

		if(list != null)			
			return list;

		return new ArrayList<Account>();
	}
	
	public Account getAccountById(String id)
	{		
		if(accountRepo.existsById(id))
			return accountRepo.getOne(id);
		
		return new Account();
	}
	
	public List<Account> getCustomersAllAccounts(String id)
	{
		if(customerRepo.existsById(id))
			return accountRepo.findByCustomerId(customerRepo.getOne(id));
	
		return new ArrayList<>();
	}
	
	@Override
	public String transferMoney(String customer_id, AccountType source, AccountType destination, double amount, String message)
	{
		if(customerRepo.existsById(customer_id))
		{
			Customer customer = customerRepo.getOne(customer_id);
			Account src  = accountRepo.findByCustomerIdAndAccountType(customer, source);
			Account dest = accountRepo.findByCustomerIdAndAccountType(customer, destination);
			
			if(src.getAmount()>amount)
			{
				src.setAmount(src.getAmount() - amount);
				dest.setAmount(dest.getAmount() + amount);
				
				src.setMessage(message);
				src.setLast_operation(AccountOperation.debited);
				src.setLast_updated(new Date());
				
				dest.setMessage(message);
				dest.setLast_operation(AccountOperation.credited);
				dest.setLast_updated(new Date());
				
				accountRepo.save(src);
				accountRepo.save(dest);
			
				String tx_id = "TX-100" + (txRepo.count() + 1);
				txRepo.save(new Transaction(tx_id, new Date(), customer.getCustomer_id(), source, destination, amount));
				
				return "transaction Successfull...!!!";
			}
			else
				return "insufficent balance";
		}
		
		return "transaction failed...!!!";
	}
}
