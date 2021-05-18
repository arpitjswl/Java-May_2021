package com.arpit.corejavacom.arpit.designpattrens;

public class FactoryPattern {

	public static void main(String[] args) {
		OS os = ObjectFactory.getObject("Android");
		os.ram();
	}

}

interface OS{
	public void ram();
}

class Android implements OS{

	@Override
	public void ram() {
		System.out.println("Android called");
		
	}
	
}

class Linux implements OS{

	@Override
	public void ram() {
		// TODO Auto-generated method stub
		
	}
	
}

class Macintosh implements OS{

	@Override
	public void ram() {
		// TODO Auto-generated method stub
		
	}
	
}

class Windows implements OS{

	@Override
	public void ram() {
		// TODO Auto-generated method stub
		
	}
	
}

class ObjectFactory{
	public static OS getObject(String input) {
		if (input.equals("Android"))
			return new Android();
		if (input.equals("Linux"))
			return new Linux();
		return null;
	}
}