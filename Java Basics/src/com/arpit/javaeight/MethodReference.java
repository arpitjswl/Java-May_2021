package com.arpit.javaeight;

public class MethodReference {

	public static void main(String[] args) {
		
		Runnable r1 = () -> System.out.println("thread is runnning");
		
		new Thread(r1).start();

	}
	
	 public static void saySomething(){  
	        System.out.println("Hello, this is static method.");  
	    }
	 
	 public static void ThreadStatus(){  
	        System.out.println("Thread is running...");  
	    }  
}


interface Sayable{  
    void say();  
}