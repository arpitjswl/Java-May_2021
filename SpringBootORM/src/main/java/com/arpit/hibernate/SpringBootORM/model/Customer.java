package com.arpit.hibernate.SpringBootORM.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cust_id;
	private String cust_name;
	
	@OneToMany(mappedBy = "cust", cascade = CascadeType.ALL)
	private Set<Vehicle> set = new HashSet<Vehicle>();
	
	public Integer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Set<Vehicle> getSet() {
		return set;
	}
	public void setSet(Set<Vehicle> set) {
		this.set = set;
	}

}
