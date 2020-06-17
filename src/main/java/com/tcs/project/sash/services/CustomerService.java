package com.tcs.project.sash.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.project.sash.model.Address;
import com.tcs.project.sash.model.Customer;
import com.tcs.project.sash.model.CustomerOperation;
import com.tcs.project.sash.model.Transaction;
import com.tcs.project.sash.repository.AddressRepository;
import com.tcs.project.sash.repository.CustomerRepository;
import com.tcs.project.sash.repository.TransactionRepository;

@Service
public class CustomerService implements CustomerServiceInterface
{
	@Autowired
	private CustomerRepository customerRepo;	
	@Autowired
	private AddressRepository addressRepo;	
	@Autowired
	private TransactionRepository txRepo;	

	
	@Override
	public String addNewCustomer(Customer customer)
	{
		if(customerRepo.existsById(customer.getCustomer_id()))
		{
			System.out.println("customers with ID : " + customer.getCustomer_id() + " Already Exists!!!");
			return "Customer with ID Already Exists...!!!";
		}
		else
		{
			customerRepo.save(customer);
			System.out.println("customers with ID : " + customer.getCustomer_id() + " ADDED Successfully!!!");
			return "new Customer Added Successfully...";
		}
	}
	
	public Customer addCustomer(Customer customer)
	{
		if(customerRepo.existsById(customer.getCustomer_id()))
		{
			System.out.println("customers with ID : " + customer.getCustomer_id() + " Already Exists!!!");
			return new Customer();
		}
		else
		{
			customerRepo.save(customer);
			System.out.println("customers with ID : " + customer.getCustomer_id() + " ADDED Successfully!!!");
			return customerRepo.getOne(customer.getCustomer_id());
		}
	}

	@Override
	public Customer getCustomerByID(String id)
	{
		if(customerRepo.existsById(id))
		{
			System.out.println("customers with ID : " + id + " FOUND...");
			Customer customer = customerRepo.getOne(id);
			
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
			if(obj.getCustomer_name().equalsIgnoreCase(name))
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
	public String deleteCustomerByID(String id)
	{
		if(customerRepo.existsById(id))
		{
			System.out.println("customers with ID : " + id + " FOUND...");
			
//				for(Transaction obj: txRepo.findByCustomerId(id))
//					txRepo.deleteById(obj.getcustomerId());

				customerRepo.deleteById(id);

			return "customers with ID : " + id + " DELETED SUCCESSFULLY...";			
		}
		
		return "customers with ID : " + id + " NOT FOUND!!!";
	}


	@Override
	public String updateCustomer(String id, Customer obj)
	{	
		if(customerRepo.existsById(id))
		{
			Customer customer = customerRepo.getOne(id);
			Address address = addressRepo.getOne(obj.getAddress().getAddress_id());
			
			System.out.println("CUSTOMER : " + customer);
			System.out.println("ADDRESS : " + address);

				customer.setCustomer_name(obj.getCustomer_name())
						.setCustomer_contact1(obj.getCustomer_contact1())
						.setCustomer_contact2(obj.getCustomer_contact2())
						.setCustomer_email(obj.getCustomer_email())
						.setAge(obj.getAge()).setDob(obj.getDob())
						.setAddress(address.setPlot(obj.getAddress().getPlot())
											.setArea(obj.getAddress().getArea())
											.setDistrict(obj.getAddress().getDistrict())
											.setState(obj.getAddress().getState())
											.setPincode(obj.getAddress().getPincode()))
						.setLast_operation(CustomerOperation.updated)
						.setLast_updated(new Date())
						.setMessage(obj.getMessage());

			customerRepo.save(customer);
			
			return "Customer with ID : " + id+ " successfully added..!!!";
		}

		return "Customer with ID : " + id + " failed to add..!!!";
	}
}
