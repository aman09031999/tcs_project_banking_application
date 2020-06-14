package com.tcs.project.sash.services;

import java.util.List;

import com.tcs.project.sash.model.Customer;

public interface BankingCURDServiceInterface
{
	public List<Customer> getCustomerByName(String name);
	public Customer findCustomerByID(String id);
	public List<Customer> getAllCustomers();
	public boolean deleteCustomerByID(String id);
	public boolean updateCustomerByID(String id);
	public Customer addCustomer(Customer Customer);
}
