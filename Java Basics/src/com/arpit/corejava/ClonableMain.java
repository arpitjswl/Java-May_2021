package com.arpit.corejava;

public class ClonableMain {

	public static void main(String[] args) {
		Asmi asmi = new Asmi("naughty", 3);
		Asmi s = null;
		
		try {
		s	= (Asmi)asmi.clone();
		}
		catch (CloneNotSupportedException e) {
			// TODO: handle exception
		}
		
		System.out.println(s);

	}

}


class Asmi implements Cloneable{
	
	private String behaviour;
	private Integer age;
	
	
	public Asmi(String behaviour, Integer age) {
		super();
		this.behaviour = behaviour;
		this.age = age;
	}
	public String getBehaviour() {
		return behaviour;
	}
	public void setBehaviour(String behaviour) {
		this.behaviour = behaviour;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Asmi [behaviour=" + behaviour + ", age=" + age + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	
}