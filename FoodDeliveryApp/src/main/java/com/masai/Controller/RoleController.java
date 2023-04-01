package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.Exception.RoleException;
import com.masai.Model.Role;
import com.masai.Service.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/roles")
@SecurityRequirement(name = "bearer-key")
public class RoleController {

	@Autowired
	RoleService roserv;

	@PostMapping("")
	public ResponseEntity<Role> addingNewRole(@Valid @RequestBody Role role) throws RoleException {

		return new ResponseEntity<>(roserv.addRole(role), HttpStatus.CREATED);

	}

	@PutMapping("")
	public ResponseEntity<Role> UpdateNewRole(@Valid @RequestBody Role role) throws RoleException {

		return new ResponseEntity<>(roserv.updateRole(role), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{roleID}")
	public ResponseEntity<String> DeleteRole(@PathVariable Integer roleID) throws RoleException {

		return new ResponseEntity<>(roserv.removeRole(roleID), HttpStatus.OK);

	}

	@GetMapping("/{roleID}")
	public ResponseEntity<Role> ViewRole(@PathVariable Integer roleID) throws RoleException {

		return new ResponseEntity<>(roserv.viewRole(roleID), HttpStatus.OK);
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Role>> ViewAllRoles() throws RoleException {

		return new ResponseEntity<>(roserv.viewALLRole(), HttpStatus.OK);
	}

}
