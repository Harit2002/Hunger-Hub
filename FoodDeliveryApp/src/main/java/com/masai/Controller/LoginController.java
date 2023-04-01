package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.Exception.UserException;
import com.masai.Model.User;
import com.masai.Repository.RoleRepo;
import com.masai.Service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
public class LoginController {

	@Autowired
	UserService userSer;

	@Autowired
	RoleRepo roleRepo;

	@Autowired
	PasswordEncoder penc;

	@GetMapping("/users/login")
	public ResponseEntity<User> loginCustomer(Authentication auth) throws UserException {

		User user = userSer.viewByEmail(auth.getName());
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}

	@PostMapping("users/signIn")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws UserException {

		user.setPassword(penc.encode(user.getPassword()));
		user.setRole(roleRepo.findById(1).get());

		return new ResponseEntity<>(userSer.regiserUser(user), HttpStatus.CREATED);

	}

	@SecurityRequirement(name = "bearer-key")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("admin/signIn")
	public ResponseEntity<User> registerAdmin(@Valid @RequestBody User user) throws UserException {

		user.setPassword(penc.encode(user.getPassword()));
		user.setRole(roleRepo.findById(2).get());

		return new ResponseEntity<>(userSer.regiserUser(user), HttpStatus.CREATED);

	}
}
