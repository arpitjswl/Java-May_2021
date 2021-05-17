package DAO;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.query.Query;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;

import com.arpit.srpingboot.AngularIntegration.model.Student;

import exception.DataNotFoundException;  
  
  
  
@Repository  
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
        if (st==null)
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
      
      
  
}  