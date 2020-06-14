package com.tcs.project.sash.services;

import com.tcs.project.sash.model.Account;
import com.tcs.project.sash.model.AccountType;
import com.tcs.project.sash.model.Customer;

public interface AccountServiceInterface
{
	public Boolean loginUser(String userName, String password);
	public Account addNewAccount(Customer customer, AccountType type, double baseAmount);
	
	public String transferMoney(String customer_id, AccountType source, AccountType destination, double amount);
	public String depositMoney(String userID, AccountType accountType, double amount);
	public String withdrawMoney(String userID, AccountType accountType, double amount);
}
