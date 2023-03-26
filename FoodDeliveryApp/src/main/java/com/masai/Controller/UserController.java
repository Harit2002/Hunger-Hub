package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.Model.User;
import com.masai.Repository.RoleRepo;
import com.masai.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userSer;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	PasswordEncoder penc;

	@PostMapping("/signIn")
	public ResponseEntity<User> registerCustomer(@RequestBody User user) {

		user.setPassword(penc.encode(user.getPassword()));
		
		return new ResponseEntity<>(userSer.regiserUser(user), HttpStatus.ACCEPTED);

	}

}
