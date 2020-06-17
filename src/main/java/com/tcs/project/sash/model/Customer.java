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
@Table(name="customer_info")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Customer
{	
	@Id
	private String customer_id;
	private String customer_aadhar_no;
	private String customer_name;
	
	@OneToOne(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address_id;
	
	private Date customer_dob;
	private int age;
	private String customer_contact1;
	private String customer_contact2;
	private String customer_email;
	
	private Date doc;
	private String message;
	private CustomerOperation last_operation;
	private Date last_updated;

	public Customer()	{	}
	
	public Customer(String customer_id, String aadhar_no, String customer_name, Address address_id,
			Date dob, int age, String contact1, String contact2, String email, Date doc)
	{
		this.customer_id = customer_id;
		this.customer_aadhar_no = aadhar_no;
		this.customer_name = customer_name;
		this.address_id = address_id;
		this.customer_dob = dob;
		this.age = age;
		this.customer_contact1 = contact1;
		this.customer_contact2 = contact2;
		this.customer_email = email;
		this.doc = doc;
	}


	public String getCustomer_id() 					{	return customer_id;			}
	public String getAadhar_no() 					{	return customer_aadhar_no;	}
	public String getCustomer_name() 				{	return customer_name;		}
	public Address getAddress() 					{	return address_id;			}
	public Date getDob() 							{	return customer_dob;		}
	public int getAge() 							{	return age;					}
	public String getCustomer_contact1() 			{	return customer_contact1;	}
	public String getCustomer_contact2()			{	return customer_contact2;	}
	public String getCustomer_email() 				{	return customer_email;		}
	public Date getDoc() 							{	return doc;					}
	public String getMessage() 						{	return message;				}
	public CustomerOperation getLast_operation() 	{	return last_operation;		}
	public Date getLast_updated() 					{	return last_updated;		}


	public Customer setCustomer_id(String customer_id) 					{	this.customer_id = customer_id;			return this;	}
	public Customer setAadhar_no(String aadhar_no) 						{	this.customer_aadhar_no = aadhar_no;	return this;	}
	public Customer setCustomer_name(String customer_name)				{	this.customer_name = customer_name;		return this;	}
	public Customer setAddress(Address address_id) 						{	this.address_id = address_id;			return this;	}
	public Customer setDob(Date dob) 									{	this.customer_dob = dob;				return this;	}
	public Customer setAge(int age) 									{	this.age = age;							return this;	}
	public Customer setCustomer_contact1(String contact1) 				{	this.customer_contact1 = contact1;		return this;	}
	public Customer setCustomer_contact2(String contact2) 				{	this.customer_contact2 = contact2;		return this;	}
	public Customer setCustomer_email(String email) 					{	this.customer_email = email;			return this;	}
	public Customer setDoc(Date doc) 									{	this.doc = doc;							return this;	}
	public Customer setMessage(String message) 							{	this.message = message;					return this;	}
	public Customer setLast_operation(CustomerOperation last_operation) {	this.last_operation = last_operation;	return this;	}
	public Customer setLast_updated(Date last_updated) 					{	this.last_updated = last_updated;		return this;	}


	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_aadhar_no=" + customer_aadhar_no
				+ ", customer_name=" + customer_name + ", address_id=" + address_id + ", customer_dob=" + customer_dob
				+ ", age=" + age + ", customer_contact1=" + customer_contact1 + ", customer_contact2="
				+ customer_contact2 + ", customer_email=" + customer_email + ", message=" + message
				+ ", last_operation=" + last_operation + ", last_updated=" + last_updated + "]";
	}
}
