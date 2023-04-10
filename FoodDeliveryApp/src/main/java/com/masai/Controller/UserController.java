package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
@SecurityRequirement(name = "bearer-key")
public class UserController {

	@Autowired
	UserService userSer;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) throws UserException {

		User user = userSer.viewById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<User>> getAllUser() throws UserException {

		List<User> user = userSer.viewAllUser();
		return new ResponseEntity<>(user, HttpStatus.OK);

	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) throws UserException {

		return new ResponseEntity<>(userSer.deleteUser(id), HttpStatus.OK);

	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable Integer id,@Valid @RequestBody User user) throws UserException {

		return new ResponseEntity<>(userSer.updateDetails(user, id), HttpStatus.ACCEPTED);

	}

}
