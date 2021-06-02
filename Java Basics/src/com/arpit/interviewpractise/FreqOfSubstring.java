package com.arpit.interviewpractise;

public class FreqOfSubstring {

	public static void main(String[] args) {
		String s1 = "man";
		String s2 = "manGoldOfmanCOVIDman";
		
		System.out.println(getCountOfSubstring(s1,s2));

	}
	
	public static Integer getCountOfSubstring(String s1, String s2) {

		Integer subLength = 0;
		
		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			int j;
			for ( j = 0; j < s1.length() ; j++) {
				if (s2.charAt(i+j) != s1.charAt(j))
					break;
			}
			
			if (s1.length() == j) {
				++subLength;
				j=0;
			}
		}
		return subLength;
	}

}


