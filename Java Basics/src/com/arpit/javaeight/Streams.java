package com.arpit.javaeight;

public class Streams {

	public static void main(String[] args) {
		String txt = "abcduu"; // AArpit
		
		
		  for (int i = 0; i < txt.length(); i++) {
		   boolean unique = false;
		   for (int j = i+1; j < txt.length(); j++) {
		    if (txt.charAt(i) != txt.charAt(j)) {
		     unique = true;
		     break;
		    }
		   }
		   if (unique) {
		    System.out.println("The first non repeated character in String is: " + txt.charAt(i));
		    break;
		   }
		  }
		
		

	}

}
