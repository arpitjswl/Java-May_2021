package com.arpit.interviewpractise;

import java.util.HashSet;

public class CheckIfArraysContainDuplicate {

	public static void main(String[] args) {
		//int arr[] = {1,2,3,1};
		int arr[] = {1,2,3};
		System.out.println( checkIfDuplicate(arr) );
	}
	
	public static boolean checkIfDuplicate(int array[]) {
		HashSet<Integer> hs = new HashSet<>();
		
		for (int data : array) {
			if (hs.contains(data))
				return true;
			hs.add(data);
		}
		return false;
	}

}
