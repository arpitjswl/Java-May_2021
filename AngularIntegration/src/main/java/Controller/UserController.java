package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.srpingboot.AngularIntegration.model.User;

import DAO.Student_DAO_Imp;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api")
public class UserController {
	
	@Autowired
	private Student_DAO_Imp dao;
	
	@PostMapping(path = "/save")
	public void saveUser(@RequestBody User user) {
		dao.saveUserData(user);
	}
}
