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
	
	private CustomerOperation last_operation;
	private Date last_updated;

	public Customer()	{	}
	
	public Customer(String customer_id, String aadhar_no, String customer_name, Address address_id,
			Date dob, int age, String contact1, String contact2, String email)
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
	}


	public String getcustomer_id() 					{	return customer_id;			}
	public String getAadhar_no() 					{	return customer_aadhar_no;	}
	public String getcustomer_name() 				{	return customer_name;		}
	public Address getaddress_id() 					{	return address_id;			}
	public Date getDob() 							{	return customer_dob;		}
	public int getAge() 							{	return age;					}
	public String getContact1() 					{	return customer_contact1;	}
	public String getContact2()						{	return customer_contact2;	}
	public String getEmail() 						{	return customer_email;		}
	public CustomerOperation getLast_operation() 	{	return last_operation;		}
	public Date getLast_updated() 					{	return last_updated;		}
	
	public Customer setcustomer_id(String customer_id) 					{	this.customer_id = customer_id;			return this;	}
	public Customer setAadhar_no(String aadhar_no) 						{	this.customer_aadhar_no = aadhar_no;	return this;	}
	public Customer setcustomer_name(String customer_name)				{	this.customer_name = customer_name;		return this;	}
	public Customer setaddress_id(Address address_id) 					{	this.address_id = address_id;			return this;	}
	public Customer setDob(Date dob) 									{	this.customer_dob = dob;				return this;	}
	public Customer setAge(int age) 									{	this.age = age;							return this;	}
	public Customer setContact1(String contact1) 						{	this.customer_contact1 = contact1;		return this;	}
	public Customer setContact2(String contact2) 						{	this.customer_contact2 = contact2;		return this;	}
	public Customer setEmail(String email) 								{	this.customer_email = email;			return this;	}
	public Customer setLast_operation(CustomerOperation last_operation) {	this.last_operation = last_operation;	return this;	}
	public Customer setLast_updated(Date last_updated) 					{	this.last_updated = last_updated;		return this;	}


	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_aadhar_no=" + customer_aadhar_no
				+ ", customer_name=" + customer_name + ", address_id=" + address_id + ", customer_dob=" + customer_dob
				+ ", age=" + age + ", customer_contact1=" + customer_contact1 + ", customer_contact2="
				+ customer_contact2 + ", customer_email=" + customer_email + ", last_operation=" + last_operation
				+ ", last_updated=" + last_updated + "]";
	}
}
