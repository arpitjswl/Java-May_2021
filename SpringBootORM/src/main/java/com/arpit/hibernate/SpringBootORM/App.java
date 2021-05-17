package com.arpit.hibernate.SpringBootORM;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.arpit.hibernate.SpringBootORM.model.Address;
import com.arpit.hibernate.SpringBootORM.model.Customer;
import com.arpit.hibernate.SpringBootORM.model.Person;
import com.arpit.hibernate.SpringBootORM.model.UserData;
import com.arpit.hibernate.SpringBootORM.model.Vehicle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		sess.beginTransaction();

		/*
		 * 
		 * for (int i = 1; i <=5; i++) { UserData user = new UserData();
		 * user.setUserName("user " + i); sess.save(user); }
		 * 
		 * 
		 * // saving or inserting to DB
		 * 
		 * UserData user = new UserData();
		 * 
		 * user.setUserName("Arpit"); user.setAddress("Nagpur"); user.setJoinedDate(new
		 * Date()); user.setDescription("Desc of User");
		 * 
		 * sess.save(user); sess.getTransaction().commit();
		 * 
		 * sess.close();
		 * 
		 * 
		 * // Retreving Objects from DB user = null;
		 * 
		 * sess = sf.openSession(); sess.beginTransaction();
		 * 
		 * UserData ret = sess.get(UserData.class, 1);
		 * 
		 * System.out.println(ret.getUserName());
		 */
		
		/*
		 * UserData user = new UserData();
		 * 
		 * user.setUserName("Arpit"); user.setJoinedDate(new Date());
		 * user.setDescription("Desc of User");
		 * 
		 * Address add = new Address(); add.setCity("nagpur");
		 * add.setState("Maharashtra"); add.setStreet("Ram nagar");
		 * 
		 * user.setAddress(add); sess.save(user);
		 * 
		 * sess.getTransaction().commit(); sess.close();
		 */

		
		/*
		 * Customer cust = new Customer(); Vehicle veh = new Vehicle(); Vehicle veh1 =
		 * new Vehicle();
		 * 
		 * 
		 * cust.setCust_name("Nandlal"); veh.setName("Audi"); veh1.setName("I10");
		 * 
		 * cust.getSet().add(veh); cust.getSet().add(veh1);
		 * 
		 * veh.setCust(cust); veh1.setCust(cust);
		 * 
		 * sess.save(cust);
		 * 
		 * sess.getTransaction().commit(); sess.close();
		 */
		
		
		// CRUD Operations'
		
		
		
		/*
		 * for (int i = 1; i <= 5; i++) { Person p = new Person();
		 * p.setPerson_name("Person : " + i); sess.save(p); }
		 */
		
		/*
		 * Person ret = sess.get(Person.class, 2);
		 * ret.setPerson_name("Name Changed using Update");
		 * 
		 * sess.update(ret);
		 * 
		 * System.out.println(ret);
		 * 
		 * sess.getTransaction().commit(); sess.close();
		 */
		
		
		
		// HQL from here
		
		String input = "2";
		String user = "Person : 4";
		javax.persistence.Query query = sess.createQuery(" from Person where person_id > ?0 and person_name = ?1");
		query.setParameter(0, Integer.parseInt(input));
		query.setParameter(1, user);
		
		List<Person> list = query.getResultList();
		
		for (Person obj : list)
			System.out.println(obj.getPerson_name());
		
		
		
		sess.getTransaction().commit();
		sess.close();
		
		System.out.println("Fetched from HQL : " + list.toString());
		
		
	}
}
