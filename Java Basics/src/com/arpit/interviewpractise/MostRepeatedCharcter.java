package com.arpit.interviewpractise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MostRepeatedCharcter {

	public static void main(String[] args) {
		String input = "ABABBBERRRRK";
		char arr[] = input.toCharArray(); 
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < input.length(); i++) {
			if (hm.containsKey(arr[i]) == false)
				hm.put(arr[i], 1);
			else {
				int count = hm.get(arr[i]);
				hm.put(arr[i], ++count);
			}
		}
		
		System.out.println(hm);
		
		char maxKey = ' ';
		int maxVal = 0;
		
		Set<Entry<Character, Integer>> set = hm.entrySet();
		
		for (Map.Entry<Character, Integer> map : set) {
			if (map.getValue() > maxVal) {
				maxVal = map.getValue();
				maxKey = map.getKey();
			}
		}
		
		
		System.out.println("Character repated most is : " + maxKey + maxVal + " times");
		System.out.println();
		
		int minVal = 1;
		char occuredOnce = ' '; 
		
		for (Map.Entry<Character, Integer> map : set) {
			if (map.getValue() == minVal) {
			
				occuredOnce = map.getKey();
				break;
			}
			
			
		}
		System.out.println("First non repeted char is : " + occuredOnce);
		
		
		
		

	}

}
