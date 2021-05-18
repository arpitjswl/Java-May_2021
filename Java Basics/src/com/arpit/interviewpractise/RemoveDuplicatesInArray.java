package com.arpit.interviewpractise;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInArray {

	public static void main(String[] args) {
		int arr[] = {1,2,3,1};
		
		Set<Integer> set = new HashSet<>();
		// 
		
		for (int i = 0; i <arr.length; i++) {
			set.add(arr[i]);
		}
		
		System.out.println(set);


	}

}
