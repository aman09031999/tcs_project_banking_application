package com.tcs.project.sash.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="account_info")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Account
{
	@Id
	private String accountId;
	private AccountType accountType;
	
	@OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customerId;

	private Date doc;
	private double amount;
	private Status status;

	public Account()	{	}
	
	public Account(String accountId, AccountType accountType, Customer customerId,
						Date doc, double amount, Status status)
	{
		this.accountId = accountId;
		this.accountType = accountType;
		this.customerId = customerId;
		this.doc = doc;
		this.amount = amount;
		this.status = status;
	}


	public String getAccountId()		{	return accountId;	}
	public Customer getCustomerId() 	{	return customerId;	}
	public Date getDoc() 				{	return doc;			}
	public double getAmount() 			{	return amount;		}
	public Status getStatus() 			{	return status;		}
	public AccountType getAccountType()	{	return accountType;	}

	public Account setAccountId(String accountId)			{	this.accountId = accountId;		return this;	}
	public Account setAccountType(AccountType accountType)	{	this.accountType = accountType;	return this;	}
	public Account setCustomerId(Customer customerId) 		{	this.customerId = customerId;	return this;	}
	public Account setDoc(Date doc) 						{	this.doc = doc;					return this;	}
	public Account setAmount(double amount) 				{	this.amount = amount;			return this;	}
	public Account setStatus(Status status) 				{	this.status = status;			return this;	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", customerId=" + customerId
				+ ", doc=" + doc + ", amount=" + amount + ", status=" + status + "]";
	}
}