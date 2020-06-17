package com.tcs.project.sash.services;

import com.tcs.project.sash.model.Account;
import com.tcs.project.sash.model.AccountType;
import com.tcs.project.sash.model.Customer;

public interface AccountServiceInterface
{
	public Boolean loginUser(String userName, String password);
	public String addNewAccount(Customer customer, AccountType type, double baseAmount, String message);
	
	public String transferMoney(String customer_id, AccountType source, AccountType destination, double amount, String message);
	public String depositMoney(String userID, AccountType accountType, double amount, String message);
	public String withdrawMoney(String userID, AccountType accountType, double amount, String message);
}
