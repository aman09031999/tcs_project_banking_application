package com.tcs.project.sash.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.project.sash.model.Customer;
//import com.tcs.project.sash.repository.AddressRepository;
import com.tcs.project.sash.repository.CustomerRepository;

@Service
public class CustomerService implements CustomerServiceInterface
{
	@Autowired
	private CustomerRepository customerRepo;
	
//	@Autowired
//	private AddressRepository addressRepo;
	
	@Override
	public Customer addCustomer(Customer customer)
	{
		if(customerRepo.existsById(customer.getcustomer_id()))
		{
			System.out.println("customers with ID : " + customer.getcustomer_id() + " Already Exists!!!");
			return new Customer();
		}
		else
		{
			customerRepo.save(customer);
			System.out.println("customers with ID : " + customer.getcustomer_id() + " ADDED Successfully!!!");
			return customer;
		}
	}

	@Override
	public Customer getCustomerByID(String id)
	{
		if(customerRepo.existsById(id))
		{
			System.out.println("customers with ID : " + id + " FOUND...");
			Customer customer = customerRepo.getOne(id);
			
//			System.out.println(customer);
//			Address address = addressRepo.getOne(customer.getaddress_id().getAddress_id());
//			customer.setaddress_id(address);
			return customer;
		}
		
		System.out.println("customers with ID : " + id + " NOT FOUND!!!");
		return new Customer();
	}
	
	@Override
	public List<Customer> getCustomerByName(String name)
	{
		List<Customer> list = new ArrayList<>();

		for(Customer obj : customerRepo.findAll())
			if(obj.getcustomer_name().equalsIgnoreCase(name))
				list.add(obj);
		
		return list;
	}

	@Override
	public List<Customer> getAllCustomers()
	{
		System.out.println("Total Count of customers : " + customerRepo.count());
		return customerRepo.findAll();
	}

	@Override
	public boolean deleteCustomerByID(String id)
	{
		if(customerRepo.existsById(id))
		{
			System.out.println("customers with ID : " + id + " FOUND...");
			customerRepo.deleteById(id);
			System.out.println("customers with ID : " + id + " DELETED SUCCESSFULLY...");
			return true;
		}
		
		System.out.println("customers with ID : " + id + " NOT FOUND!!!");
		return false;
	}


	@Override
	public boolean updateCustomerByID(String id)
	{	
		if(customerRepo.existsById(id))
			return true;

		return false;
	}
}
