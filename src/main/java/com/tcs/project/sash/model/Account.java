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
	
	private String message;
	private AccountOperation last_operation;
	private Date last_updated;

	public Account()	{	}
	
	public Account(String accountId, AccountType accountType, Customer customerId,
						Date doc, double amount, Status status, String message,
						AccountOperation last_operation, Date last_updated)
	{
		this.accountId = accountId;
		this.accountType = accountType;
		this.customerId = customerId;
		this.doc = doc;
		this.amount = amount;
		this.status = status;
		this.message = message;
		this.last_operation = last_operation;
		this.last_updated = last_updated;
	}

	public String getAccountId()				{	return accountId;		}
	public AccountType getAccountType()			{	return accountType;		}
	public Customer getCustomerId() 			{	return customerId;		}
	public Date getDoc() 						{	return doc;				}
	public double getAmount() 					{	return amount;			}
	public Status getStatus() 					{	return status;			}
	public String getMessage() 					{	return message;			}
	public AccountOperation getLast_operation()	{	return last_operation;	}
	public Date getLast_updated() 				{	return last_updated;	}
	
	
	public Account setAccountId(String accountId)						{	this.accountId = accountId;				return this;	}
	public Account setAccountType(AccountType accountType)				{	this.accountType = accountType;			return this;	}
	public Account setCustomerId(Customer customerId) 					{	this.customerId = customerId;			return this;	}
	public Account setDoc(Date doc) 									{	this.doc = doc;							return this;	}
	public Account setAmount(double amount) 							{	this.amount = amount;					return this;	}
	public Account setStatus(Status status) 							{	this.status = status;					return this;	}
	public Account setMessage(String message)							{	this.message = message;					return this;	}
	public Account setLast_operation(AccountOperation last_operation)	{	this.last_operation = last_operation; 	return this;	}
	public Account setLast_updated(Date last_updated) 					{	this.last_updated = last_updated;		return this;	}

	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", customerId=" + customerId
				+ ", doc=" + doc + ", amount=" + amount + ", status=" + status + ", last_operation=" + last_operation
				+ ", last_updated=" + last_updated + "]";
	}
}