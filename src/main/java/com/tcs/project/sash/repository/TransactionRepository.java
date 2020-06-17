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
	@Query(value = "SELECT * FROM transaction_info WHERE dot BETWEEN :from AND :to", nativeQuery=true)
	List<Transaction> findByDot(@Param("from") Date from, @Param("to") Date to);
	
//	@Query(value = "SELECT * FROM transaction_info WHERE customer_id:id ", nativeQuery=true)
	List<Transaction> findByCustomerId(String id);
}