package com.arpit.interviewpractise;

public class MaxNumberInArray {

	public static void main(String[] args) {
		Integer arr[] = {11, 32, -9, 7, 23};
		System.out.println(findMax(arr));
	}
	
	public static Integer findMax(Integer arr[]) {
		int maxNum = arr[0];
		
		for (int i = 0; i<arr.length; i++) {
			if (arr[i]> maxNum )
				maxNum = arr[i];
		}
		return maxNum;
	}
}
