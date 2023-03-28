package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Model.User;
import com.masai.Repository.UserRepo;

@RestController
public class LoginController {
	
	@Autowired
	UserRepo repo;
	 
    @GetMapping("users/login")
    public ResponseEntity<User> loginCustomer(Authentication auth) {
    	
    	User user = repo.findByEmail(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    	return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }
}
