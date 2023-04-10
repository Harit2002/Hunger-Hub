package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.masai.Exception.AddressException;
import com.masai.Exception.RestaurantException;
import com.masai.Exception.UserException;
import com.masai.Model.Address;
import com.masai.Service.AddressService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "bearer-key")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/user/{userId}")
	public ResponseEntity<Address> addAddressToUser(@RequestBody Address address, @PathVariable Integer userId)
			throws UserException, AddressException {

		return new ResponseEntity<>(addressService.addAddressToUser(address, userId), HttpStatus.CREATED);

	}

	@PutMapping("/user/{userId}/{addressId}")
	public ResponseEntity<Address> updateAddressToUser(@RequestBody Address address, @PathVariable Integer userId,
			Integer addressId) throws AddressException, UserException {

		return new ResponseEntity<>(addressService.updateAddressToUser(address, userId, addressId), HttpStatus.ACCEPTED);

	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/restaurants/{restaurantId}")
	public ResponseEntity<Address> addAddressToRestaurant(@RequestBody Address address,
			@PathVariable Integer restaurantId) throws RestaurantException, AddressException {

		return new ResponseEntity<>(addressService.addAddressToRestaurant(address, restaurantId), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/restaurants/{restaurantId}/{addressId}")
	public ResponseEntity<Address> updateAddressToRestaurant(@RequestBody Address address, @PathVariable Integer restaurantId,
			@PathVariable Integer addressId) throws RestaurantException, AddressException {

		return new ResponseEntity<>(addressService.updateAddressToRestaurant(address, restaurantId, addressId),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/users/{userId}/{addressId}")
	public ResponseEntity<Address> deleteAddressFromUser(@PathVariable Integer userId, @PathVariable Integer addressId)
			throws UserException, AddressException {

		return new ResponseEntity<>(addressService.deleteAddressOfUser(userId, addressId), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/restaurants/{restaurantId}/{addressId}")
	public ResponseEntity<Address> deleteAddressFromRestaurant(@PathVariable Integer restaurantId,
			@PathVariable Integer addressId) throws RestaurantException, AddressException {

		return new ResponseEntity<>(addressService.deleteAddressOfRestaurant(restaurantId, addressId), HttpStatus.OK);
	}
}
