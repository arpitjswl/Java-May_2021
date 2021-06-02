package com.arpit.srpingboot.AngularIntegration.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.data.repository.cdi.Eager;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cust_tbl")
public class Customer {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Integer cust_id;
	private String name;
	
	@JsonIgnore
	@OneToMany
	@Cascade(CascadeType.ALL)
	@JoinColumn(name="cust_id")  
	private List<Address> address = new LinkedList<>();
	
	public Customer() {}

	public Integer getCust_id() {
		return cust_id;
	}

	public void setCust_id(Integer cust_id) {
		this.cust_id = cust_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", name=" + name + ", address=" + address + "]";
	}
	
}
