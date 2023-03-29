package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Repository.RoleRepo;
import com.masai.Service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

	@Autowired
	UserService userSer;


	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) throws UserException {

		User user = userSer.viewById(id);
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

	}
	
	@GetMapping("")
	public ResponseEntity<List<User>> getAllUser() throws UserException {

		List<User> user = userSer.viewAllUser();
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) throws UserException {

		return new ResponseEntity<>(userSer.deleteUser(id), HttpStatus.ACCEPTED);

	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) throws UserException {

		return new ResponseEntity<>(userSer.updateDetails(user, id), HttpStatus.ACCEPTED);

	}

}
