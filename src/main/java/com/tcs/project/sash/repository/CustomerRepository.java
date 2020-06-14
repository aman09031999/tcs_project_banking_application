package com.tcs.project.sash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.tcs.project.sash.model.Customer;

@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<Customer, String>
{
/*
	Customer findByCustomer_id(String id);
	Customer findByCustomeraddharno(String addhar);
	Customer findByCustomeremail(String email);
	
	List<Customer> findByCustomername(String name);
	
	Address findByAddress(String id);
*/
}