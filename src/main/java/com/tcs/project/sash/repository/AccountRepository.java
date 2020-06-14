package com.tcs.project.sash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.tcs.project.sash.model.Account;
import com.tcs.project.sash.model.AccountType;
import com.tcs.project.sash.model.Customer;


@EnableJpaRepositories
public interface AccountRepository extends JpaRepository<Account, String>
{

	@Query(value = "SELECT amount FROM account_info WHERE customer_id = :customer_id AND account_type = :type", nativeQuery=true)
	double getAmountFromAccount(@Param("customer_id") String customer_id, @Param("type") int type);
	
//	Customer findByAccountId(String account_id);
	Account findByAccountId(String account_id);
	Account findByCustomerIdAndAccountType(Customer customer_id, AccountType type);
	List<Account> findByCustomerId(Customer customer_id);
	
	List<Account> findByAccountType(AccountType type);

}