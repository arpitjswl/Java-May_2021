package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.query.Query;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.arpit.srpingboot.AngularIntegration.model.Customer;
import com.arpit.srpingboot.AngularIntegration.model.Student;
import com.arpit.srpingboot.AngularIntegration.model.User;
import exception.DataNotFoundException;
import exception.EmailExistsException;  
  
  
  
@Repository
@Transactional
public class Student_DAO_Imp  implements Student_DAO{  
  
    @Autowired  
    private SessionFactory sessionFactory;  
      
    @Override  
    public boolean saveStudent(Student student) {  
        boolean status=false;  
        try {  
             sessionFactory.getCurrentSession().save(student);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
  
    @Override  
    public List<Student> getStudents()  {  
        Session currentSession = sessionFactory.getCurrentSession();  
        Query<Student> query=currentSession.createQuery("from Student", Student.class);  
        List<Student> list=query.getResultList();
        return list;  
    }  
  
    @Override  
    public boolean deleteStudent(Student student) {  
        boolean status=false;  
        try {  
            sessionFactory.getCurrentSession().delete(student);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
  
    @Override  
    public List<Student> getStudentByID(Student student) {
    	
        Session currentSession = sessionFactory.getCurrentSession();  
        Query<Student> query=currentSession.createQuery("from Student where student_id=:student_id", Student.class);  
        query.setParameter("student_id", student.getStudent_id());  
        List<Student> list=query.getResultList();
        Student st = sessionFactory.getCurrentSession().get(Student.class, student.getStudent_id());
        if (st == null )
        	throw new DataNotFoundException("NOT FOUND !!!!!!!!!!!!");
		
         return list;  
    }  
  
    @Override  
    public boolean updateStudent(Student student) {  
        boolean status=false;  
        try {  
        	//Student st = sessionFactory.getCurrentSession().get(Student.class, student.getStudent_id());
            sessionFactory.getCurrentSession().update(student);  
            status=true;  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return status;  
    }  
    
    @Override
    public List<String> getBranchfromDB(){
    		List<String> branch = new ArrayList<>();
    	 Session currentSession = sessionFactory.getCurrentSession();
    	 Query query = currentSession.createQuery("Select student_branch from Student");
    	// Query query = currentSession.createQuery("from Student");
    	 branch = query.getResultList();
    	 return branch;
    	 
    }

	@Override
	public List<Customer> getCustomerAddress() {
		List<Customer> customer = new LinkedList<>();
		 Session currentSession = sessionFactory.getCurrentSession();
		 Query query = currentSession.createQuery("from Customer");
		 customer = query.getResultList();		 
		 return customer;
	}
      
	/*
	 * API's for Angular Project starts here
	 */
	
	
	 public List<User> getAllUsersfromDB() {
		 Session currentSession = sessionFactory.getCurrentSession();
		 Query query = currentSession.createQuery("from User");
		 List<User> list = query.getResultList();
		 return list;
     }
	 

		public void saveUserData(User user) {
			
				Session currentSession = sessionFactory.getCurrentSession();
				Query query = currentSession.createQuery("from User");
				List<User> list = query.getResultList();
				Iterator itr = list.iterator();

				if (list.size() == 0)
					sessionFactory.getCurrentSession().save(user);
				
				while (itr.hasNext()) {
					User dbUser = (User) itr.next();
					System.out.println("Passed email from Input ::::::" + user.getUser_email());
					System.out.println("DB Email ::::::" + dbUser.getUser_email());

					if (dbUser.getUser_email().equals(user.getUser_email()))
						throw new EmailExistsException("Email Already exists in Database");
					if (dbUser.getUser_email() != user.getUser_email())
						sessionFactory.getCurrentSession().save(user);
			} 
		} 
      
      public User getUser(String email) {
    	  Session currentSession = sessionFactory.getCurrentSession();
    	  Query query = currentSession.createQuery("from User where user_email =: email");
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
    	  Query query = currentSession.createQuery("from User where user_email =: email");
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