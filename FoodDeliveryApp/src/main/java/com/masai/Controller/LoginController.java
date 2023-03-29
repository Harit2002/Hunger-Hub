package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Repository.RoleRepo;
import com.masai.Repository.UserRepo;
import com.masai.Service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	UserService userSer;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	PasswordEncoder penc;

	@PostMapping("/signIn")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws UserException {

		user.setPassword(penc.encode(user.getPassword()));
		user.setRole(roleRepo.findById(2).get());

		return new ResponseEntity<>(userSer.regiserUser(user), HttpStatus.ACCEPTED);

	}

	
	 
    @GetMapping("users/login")
    public ResponseEntity<User> loginCustomer(Authentication auth) {
    	
    	User user = repo.findByEmail(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    	return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
