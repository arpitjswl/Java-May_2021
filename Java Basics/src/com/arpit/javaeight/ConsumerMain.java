package com.arpit.javaeight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsumerMain {
	public static void main(String args[]) {
	
		 	List<Product> list=new ArrayList<Product>();  
		 
	        list.add(new Product(1,"Samsung A5",17000f));  
	        list.add(new Product(3,"Iphone 6S",65000f));  
	        list.add(new Product(2,"Sony Xperia",25000f));  
	        list.add(new Product(4,"Nokia Lumia",15000f));  
	        list.add(new Product(5,"Redmi4 ",26000f));  
	        list.add(new Product(6,"Lenevo Vibe",19000f));  
	          
		
	        Collections.sort(list, 
	        		(p1, p2) -> p1.name.compareTo(p2.name)
	        		);
	        
	        for (Product p : list) {
	        	System.out.println(p.name);
	        }
	        
	        System.out.println("-----------------");
	        list.stream().filter( x -> x.price > 20000 && x.price < 60000 ).collect(Collectors.toList()).
	        	forEach( p -> System.out.println(p.price));
	        
	        list.stream().map( x -> x.price *100).collect(Collectors.toList()).
	        	forEach(p->System.out.println(p));
	        

	}
}



class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        super();  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }  
}  