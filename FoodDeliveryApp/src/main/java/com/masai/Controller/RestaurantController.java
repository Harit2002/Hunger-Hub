package com.masai.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.masai.Exception.ItemException;
import com.masai.Exception.RestaurantException;
import com.masai.Model.Restaurant;
import com.masai.Service.RestaurantService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;



@RestController
@RequestMapping("restaurants")
@SecurityRequirement(name = "bearer-key")
public class RestaurantController {
	
	@Autowired
	RestaurantService repo;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("")
	public ResponseEntity<Restaurant> addingNewRestaurant(@Valid @RequestBody Restaurant res) throws RestaurantException{
	
		return new ResponseEntity<>(repo.addRestaurant(res), HttpStatus.CREATED);	
	
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("")
	public ResponseEntity<Restaurant> updateRestaurant(@Valid @RequestBody Restaurant res) throws RestaurantException{
		
		return new ResponseEntity<>(repo.updateRestaurant(res), HttpStatus.ACCEPTED);
	
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{resID}")
	public ResponseEntity<String> removeRestaurantDetail(@PathVariable Integer resID) throws RestaurantException {
		
		return new ResponseEntity<>(repo.removeRestaurant(resID), HttpStatus.OK);
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurant> getRestaurant(@PathVariable Integer id) throws RestaurantException{
		
		return new ResponseEntity<>(repo.viewRestaurant(id), HttpStatus.OK);
	
	}
	
	@GetMapping("item/{id}")
	public ResponseEntity<Restaurant> viewRestaurantByItem(@PathVariable Integer id) throws RestaurantException, ItemException{
		
		return new ResponseEntity<>(repo.viewRestaurantByItem(id), HttpStatus.OK);

	
	}
	
	@GetMapping("location/{location}")
	public ResponseEntity<List<Restaurant>> viewRestaurantByLocation(@PathVariable String location) throws RestaurantException, ItemException{
		
		return new ResponseEntity<>(repo.viewRestaurantByLocation(location), HttpStatus.OK);
	
	}

}
