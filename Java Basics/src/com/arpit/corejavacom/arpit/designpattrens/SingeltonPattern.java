package com.arpit.corejavacom.arpit.designpattrens;

public class SingeltonPattern {

	public static void main(String[] args) {
		
		Singelton s = Singelton.getObj();
		System.out.println(s.msg);
		
		Singelton s1 = Singelton.getObj();
		s1.msg = "Object Changed";
		
		System.out.println(s.msg);
		System.out.println(s1.msg);
		
		Singelton c1 = Singelton.getObj(); Singelton c2 = Singelton.getObj();
		
		System.out.println(c1 + "----------" + c2);
		
	}
}


class Singelton{
	private static Singelton singelton = null;
	public String msg;
	
	private Singelton() {
		msg = "Object Constructed";
	}
	
	public static Singelton getObj() {
		if (singelton == null)
			singelton = new Singelton();
		return singelton;
	}	
}
