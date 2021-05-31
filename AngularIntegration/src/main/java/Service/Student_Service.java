package Service;

import java.util.List;

import com.arpit.srpingboot.AngularIntegration.model.Customer;
import com.arpit.srpingboot.AngularIntegration.model.Student;  
  
public interface Student_Service {  
  
      
    public boolean saveStudent(Student student);  
    public List<Student> getStudents();  
    public boolean deleteStudent(Student student);  
    public List<Student> getStudentByID(Student student);  
    public boolean updateStudent(Student student);
    public List<String> getBranchfromDB();
    public List<Customer> getCustomerAddress();
}  