package com.tcs.project.sash.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.project.sash.model.Transaction;
import com.tcs.project.sash.repository.TransactionRepository;

@Service
public class TransactionService
{
	@Autowired
	private TransactionRepository txRepo;
	
	public boolean addTransaction(Transaction tx)
	{
		if(tx != null)
		{	
			txRepo.save(tx);
			return true;
		}

		return false;
	}
	
	public List<Transaction> getAllTransaction()
	{
		List<Transaction> list = txRepo.findAll();
		
		if(list != null)
			return list;

		return new ArrayList<>();
	}
	
	public List<Transaction> getTransactioninRangeFromLast(int number)
	{
		List<Transaction> list = txRepo.findAll();
		
		if(list != null)
			return list;

		return new ArrayList<>();
	}
	
	public List<Transaction> getTransactioninRangeFromBegin(int number)
	{
		List<Transaction> list = txRepo.findAll();
		
		if(list != null)
			return list;

		return new ArrayList<>();
	}
}
