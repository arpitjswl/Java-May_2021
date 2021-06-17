package DAO;

import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.arpit.srpingboot.AngularIntegration.model.User;
import exception.DataNotFoundException;
import exception.EmailExistsException;
import exception.UserNotFoundException;

@Repository
@Transactional
public class User_DAO_Impl {

	 @Autowired  
	 private SessionFactory sessionFactory;

	    
		/*
		 * API's for Angular Project starts here
		 */
		
	 
	 public List<User> getAllUsersfromDB() {
		 Session currentSession = sessionFactory.getCurrentSession();
		 Query query = currentSession.getNamedQuery("getAllUsers");
		 List<User> list = query.getResultList();
		 
		 	if (list.size() == 0)
		 		throw new DataNotFoundException("No data Found in Database");
		 	return list;
    }
	 
	 public User getUserById(Integer id) {
		 Session currentSession = sessionFactory.getCurrentSession();
		 User user = currentSession.get(User.class, id);
		 if (user == null)
			 throw new UserNotFoundException("Student with id : " + id + " is not found");
		 else
			 return user; 
	 }
	 

		public void saveUserData(User user) {
			
			Session currentSession = sessionFactory.getCurrentSession();
			Query query = currentSession.getNamedQuery("getAllUsers");
			List<User> list = query.getResultList();
			Iterator itr = list.iterator();

			if (list.size() == 0)
				sessionFactory.getCurrentSession().save(user);

			while (itr.hasNext()) {
				User dbUser = (User) itr.next();
				if (dbUser.getUser_email().equals(user.getUser_email()))
					throw new EmailExistsException("Email Already exists in Database");
				if (dbUser.getUser_email() != user.getUser_email())
					sessionFactory.getCurrentSession().save(user);
			}
		} 
     
     public User getUser(String email) {
   	  Session currentSession = sessionFactory.getCurrentSession();
   	  Query query = currentSession.getNamedQuery("getUserByEmail");
   	  query.setParameter("email", email);
   	  User user = (User)query.getSingleResult();
   	  System.out.println("user is " + user);
   	  if (user != null)
   		  return user;
   	 return null;		  
     }
     
     /*
      * Method For Updating user Data in Database
      */
     
     public boolean updateInDB(User user) {
   	  User userObj = sessionFactory.getCurrentSession().get(User.class, user.getUser_id());
   	  
   	  userObj.setUser_name(user.getUser_name());
   	  userObj.setUser_email(user.getUser_email());
   	  userObj.setUser_address(user.getUser_address());
   	  userObj.setUser_password(user.getUser_password());
   	  userObj.setUser_mobile(user.getUser_mobile());
   	  
   	  sessionFactory.getCurrentSession().update(userObj);
   	  return true;
     }
     
     public boolean checkEmail(String email) {
   	  Session currentSession = sessionFactory.getCurrentSession();
   	  Query query = currentSession.getNamedQuery("getUserByEmail");
   	  query.setParameter("email", email);
   	  List<User> list = query.getResultList();
   	  Iterator itr = list.iterator();
   	  
   	  while (itr.hasNext()) {
   		  User user = (User)itr.next();
   		  if (user.getUser_email().equals(email))
   			  return true;
   	  }
   	  return false;
     }	
 
}
