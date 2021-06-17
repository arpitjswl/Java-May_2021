package com.arpit.srpingboot.AngularIntegration.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "user_data")
@NamedQuery(query = "from User", name = "getAllUsers")
@NamedQuery(query = "from User where user_email =: email", name = "getUserByEmail")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer user_id;
	
	private String user_name;
	private String user_email;
	private Long user_mobile;
	private String user_address;
	private String user_password;
	
	public User() {}
	
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Long getUser_mobile() {
		return user_mobile;
	}
	public void setUser_mobile(Long user_mobile) {
		this.user_mobile = user_mobile;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_mobile="
				+ user_mobile + ", user_address=" + user_address + "]";
	}
}
