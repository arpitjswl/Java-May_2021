package com.arpit.corejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortUsingComparable {

	public static void main(String[] args) {
		
		List<User> list = new ArrayList();
		list.add(new User(104, "Arpit", "Nagpur"));
		list.add(new User(102, "Anuj", "Balewadi"));
		list.add(new User(103, "Sakshi", "Dehradun"));
		list.add(new User(101, "Suchita", "Pune"));
		
		// Collections.sort(list); // using Comparable
		
		
		//list.sort((User user1, User user2) -> user1.getUser_name().compareTo(user2.getUser_name()));
		list.sort((User user1, User user2) -> user1.getUser_id() > user2.getUser_id() ? 1 : -1); // using Comparator
		
		
		list.sort((User user1, User user2) -> {
			if (user1.getUser_id() > user2.getUser_id())
				return 1;
			if (user1.getUser_id() < user2.getUser_id())
				return -1;
			else
				return 0;
		});
		
		System.out.println(list);
		
		
		
		for(User st:list)  
			System.out.println(st.getUser_id());  
		
	}

}


class User implements Comparable<User>{
	private Integer user_id;
	private String user_name;
	private String user_address;
	
	public User(Integer user_id, String user_name, String user_address) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_address = user_address;
	}
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
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_address=" + user_address + "]";
	}
	
	public int compareTo(User user) {
		if (this.getUser_id() > user.getUser_id())
			return 1;
		else if (this.getUser_id() < user.getUser_id())
			return -1;
		else 
			return 0;
		
	}
	
	
	
	
}