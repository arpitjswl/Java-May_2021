package com.arpit.hibernate.SpringBootORM.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer veh_id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private Customer cust;
	
	public Integer getVeh_id() {
		return veh_id;
	}
	public void setVeh_id(Integer veh_id) {
		this.veh_id = veh_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}
	
	
}
