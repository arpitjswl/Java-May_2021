package com.arpit.corejava;

import java.util.HashMap;
import java.util.LinkedHashMap;



public class HashCodeAndEqualsImpl {

	public static void main(String[] args) {
		Customer c1 = new Customer(101, "Arpit");
		Customer c2 = new Customer(101, "Arpit");
		
		System.out.println(c1.equals(c2));
		System.out.println(c1.hashCode() +"--" + c2.hashCode());
		
		HashMap<Customer, String> hm = new LinkedHashMap<>();
		
		hm.put(c1, "Delhi");
		hm.put(c2, "Nagpur");
		
		System.out.println(hm.size());

	}

}


class Customer{
	
	private Integer cust_id;
	private String cust_name;
	
	
	public Customer(Integer cust_id, String cust_name) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
	}
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
	@Override
	public String toString() {
		return "Customer [cust_id=" + cust_id + ", cust_name=" + cust_name + "]";
	}	
	
	@Override
	public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null)
				return false;
			if(this.getClass() != o.getClass())
				return false;
			Customer c = (Customer)o;
			if (c.getCust_id() == this.getCust_id() && c.getCust_name() == this.getCust_name())
				return true;
			return false;
			
	}
	
	@Override
	public int hashCode() {
		int prime = 30;
		int id = 1;
		return (prime * id) + this.getCust_id();
	}	
}
