package com.arpit.srpingboot.AngularIntegration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer add_id;
	
	private String address;
	
	/*
	 * @ManyToOne private Customer cust;
	 */

	public Integer getAdd_id() {
		return add_id;
	}

	public void setAdd_id(Integer add_id) {
		this.add_id = add_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * public Customer getCust() { return cust; }
	 * 
	 * public void setCust(Customer cust) { this.cust = cust; }
	 */

	@Override
	public String toString() {
		return "Address [add_id=" + add_id + ", address=" + address + ", cust="  + "]";
	}
	
	
}
