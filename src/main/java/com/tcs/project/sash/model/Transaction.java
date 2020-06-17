package com.tcs.project.sash.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="transaction_info")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Transaction
{
	@Id
	private String tx_id;
	private Date dot;					//	dot : Date-of-transaction	
	private String customerId;
	private AccountType source;
	private AccountType destination;
	private double amount;

	public Transaction()	{	}
	
	public Transaction(String tx_id, Date dot, String customer_id, AccountType source,
						AccountType destination, double amount)
	{
		this.tx_id = tx_id;
		this.dot = dot;
		this.customerId = customer_id;
		this.source = source;
		this.destination = destination;
		this.amount = amount;
	}


	public String getTx_id() 			{	return tx_id;			}
	public Date getDot() 				{	return dot;				}
	public String getcustomerId() 		{	return customerId;		}
	public AccountType getSource() 		{	return source;			}
	public AccountType getDestination() {	return destination;		}
	public double getAmount() 			{	return amount;			}

	public Transaction setTx_id(String tx_id) 					{	this.tx_id = tx_id;					return this;	}
	public Transaction setDot(Date dot) 						{	this.dot = dot;						return this;	}
	public Transaction setcustomerId(String customer_id)		{	this.customerId = customer_id;		return this;	}
	public Transaction setSource(AccountType source) 			{	this.source = source;				return this;	}
	public Transaction setDestination(AccountType destination)	{	this.destination = destination;		return this;	}
	public Transaction setAmount(double amount) 				{	this.amount = amount;				return this;	}


	@Override
	public String toString() {
		return "Transaction [tx_id=" + tx_id + ", dot=" + dot + ", customer_id=" + customerId + ", source=" + source
				+ ", destination=" + destination + ", amount=" + amount + "]";
	}	
}