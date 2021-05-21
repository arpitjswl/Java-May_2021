package com.arpit.javaeight;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateInterface {

	public static void main(String[] args) {
		 List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	        Predicate<Integer> noGreaterThan5 = x -> x > 5;
	        Predicate<Integer> noLessThan8 = x -> x < 8;
		 
	        List<Integer> collect = list.stream()
	                .filter(noGreaterThan5.and(noLessThan8))
	                .collect(Collectors.toList());
	        			System.out.println(collect);



	List<Map<Integer, String>> listNew = new LinkedList<>();
	
	Map<Integer, String> map = new Hashtable<>();
	map.put(101, "Neha");
	map.put(102, "SNeha");
	
	listNew.add( map );
	System.out.println(listNew);
		

	}

}
 