package com.tcs.project.sash.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_address")
public class Address
{
	@Id
	private String address_id;
	private String plot;
	private String area;
	private String district;
	private String state;
	private int pincode;

	public Address()	{	}
	
	public Address(String address_id, String plot, String area, String district, String state, int pincode) {
		this.address_id = address_id;
		this.plot = plot;
		this.area = area;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}
	public String getAddress_id() 	{	return address_id;	}
	public String getPlot() 		{	return plot;		}
	public String getArea() 		{	return area;		}
	public String getDistrict() 	{	return district;	}
	public String getState() 		{	return state;		}
	public int getPincode() 		{	return pincode;		}

	public Address setAddress_id(String address_id) {	this.address_id = address_id;	return this;	}
	public Address setPlot(String plot) 			{	this.plot = plot;				return this;	}
	public Address setArea(String area) 			{	this.area = area;				return this;	}
	public Address setDistrict(String district) 	{	this.district = district;		return this;	}
	public Address setState(String state) 			{	this.state = state;				return this;	}
	public Address setPincode(int pincode) 			{	this.pincode = pincode;			return this;	}

	@Override
	public String toString() {
		return plot + "," + area + ", " + district + ", " + state + ", " + pincode;
	}
}
