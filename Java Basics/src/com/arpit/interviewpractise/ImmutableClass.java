package com.arpit.interviewpractise;

public class ImmutableClass {

	public static void main(String[] args) {
		
		Age age = new Age();
	    age.setDay(1);
	    age.setMonth(1);
	    age.setYear(1992);
		
		Users user = new Users(101, "Ayush", "Noida", age);


		 System.out.println("Alex age year before modification = " + user.getUser_age().getYear());
		 user.getUser_age().setYear(1993);
		 System.out.println("Alex age year after modification = " + user.getUser_age().getYear());
	}

}

final class Users{
	
	private final Integer user_id;
	private final String user_name;
	private final String user_city;
	private final Age user_age;
	
	public Users(Integer user_id, String user_name, String user_city, Age age) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_city = user_city;
		
	this.user_age = age;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public String getUser_city() {
		return user_city;
	}
	
	

	public Age getUser_age() {
		 Age cloneAge = new Age();
		    cloneAge.setDay(this.user_age.getDay());
		    cloneAge.setMonth(this.user_age.getMonth());
		    cloneAge.setYear(this.user_age.getYear());

		    return cloneAge;
	}

	@Override
	public String toString() {
		return "Users user_age="
				+ user_age + "]";
	}	
}


class Age {

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
    this.day = day;
    }

    public int getMonth() {
    	return month;
    }

    public void setMonth(int month) {
    this.month = month;
    }

    public int getYear() {
    return year;
    }

    public void setYear(int year) {
    this.year = year;
    }
    
	@Override
	public String toString() {
		return "Age [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
    
}