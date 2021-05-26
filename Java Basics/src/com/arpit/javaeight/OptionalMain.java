package com.arpit.javaeight;

import java.util.Optional;

public class OptionalMain {

	public static void main(String[] args) {
		String s = null;
		
		Optional<String> opt = Optional.ofNullable(s);
		
		opt.ifPresent(System.out::print);
		
		if (opt.isPresent())
			System.out.println("Not null");
				

	}

}
