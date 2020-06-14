package com.tcs.project.sash.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import com.tcs.project.sash.model.Transaction;

@EnableJpaRepositories
public interface TransactionRepository extends JpaRepository<Transaction, String>
{
	@Query(value = "SELECT * transaction_info WHERE dot BETWEEN :from AND :to", nativeQuery=true)
	List<Transaction> findByDot(@Param("from") Date from, @Param("to") Date to);
}
/*
	public TransactionRepository()
	{
		txList.add(new Transaction("T-001", new Date(), userRepo.getAllUsers().get(randomUser(min, max)), AccountType.current, AccountType.saving, 2000.00));
		txList.add(new Transaction("T-002", new Date(), userRepo.getAllUsers().get(randomUser(min, max)), AccountType.saving, AccountType.current, 4000.00));
		txList.add(new Transaction("T-003", new Date(), userRepo.getAllUsers().get(randomUser(min, max)), AccountType.saving, AccountType.current, 1000.00));
		txList.add(new Transaction("T-004", new Date(), userRepo.getAllUsers().get(randomUser(min, max)), AccountType.current, AccountType.saving, 6000.00));
		txList.add(new Transaction("T-005", new Date(), userRepo.getAllUsers().get(randomUser(min, max)), AccountType.current, AccountType.saving, 9000.00));
		txList.add(new Transaction("T-006", new Date(), userRepo.getAllUsers().get(randomUser(min, max)), AccountType.saving, AccountType.current, 7000.00));
		txList.add(new Transaction("T-007", new Date(), userRepo.getAllUsers().get(randomUser(min, max)), AccountType.saving, AccountType.current, 1000.00));
		txList.add(new Transaction("T-008", new Date(), userRepo.getAllUsers().get(randomUser(min, max)), AccountType.current, AccountType.saving, 5000.00));
	}	
*/