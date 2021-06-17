package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.srpingboot.AngularIntegration.model.User;

import DAO.Student_DAO_Imp;
import DAO.User_DAO_Impl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class UserController {
	
	@Autowired
	private User_DAO_Impl dao;
	
	@GetMapping(path = "/getAllUsers")
	public List<User> getAllUsers() {
		return dao.getAllUsersfromDB();
	}
	
	@GetMapping(path = "/getUserById/{id}")
	public User getUserById(@PathVariable("id") Integer id) {
		return dao.getUserById(id);
	}
	
	@GetMapping(path = "/getEmail/{inputEmail}")
	public boolean checkIfEmailExists(@PathVariable("inputEmail") String inputEmail) {
		return dao.checkEmail(inputEmail);
	}
	
	@GetMapping(path = "/getUser/{email}")
	public User fetchUser(@PathVariable("email") String email) {
		return dao.getUser(email);
	}
	
	@PostMapping(path = "/save")
	public void saveUser(@RequestBody User user) {
		dao.saveUserData(user);
	}
	
	@PutMapping(path = "/update/{id}")
	public boolean updateUser(@RequestBody User user,@PathVariable("id") Integer id) {
		user.setUser_id(id);
		return dao.updateInDB(user);
	}
}
