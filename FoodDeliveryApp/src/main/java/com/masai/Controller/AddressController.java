package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AddressException;
import com.masai.Exception.RestaurantException;
import com.masai.Exception.UserException;
import com.masai.Model.Address;
import com.masai.Service.AddressService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/user/{userId}")
	public ResponseEntity<Address> addAddressToUser(@RequestBody Address address, @PathVariable Integer userId)
			throws UserException {

		return new ResponseEntity<>(addressService.addAddressToUser(address, userId), HttpStatus.OK);

	}

	@PutMapping("/user/{userId}/{addressId}")
	public ResponseEntity<Address> updateAddressToUser(@RequestBody Address address, @PathVariable Integer userId,
			Integer addressId) throws AddressException, UserException {

		return new ResponseEntity<>(addressService.updateAddressToUser(address, userId, addressId), HttpStatus.OK);

	}

	@PostMapping("/restaurant/{restaurantId}")
	public ResponseEntity<Address> addAddressToRestaurant(@RequestBody Address address,
			@PathVariable Integer restaurantId) throws RestaurantException, AddressException {

		return new ResponseEntity<>(addressService.addAddressToRestaurant(address, restaurantId), HttpStatus.OK);
	}

	@PutMapping("/restaurant/{restaurantId}/{addressId}")
	public ResponseEntity<?> updateAddressToRestaurant(@RequestBody Address address, @PathVariable Integer restaurantId,
			@PathVariable Integer addressId) throws RestaurantException, AddressException {

		return new ResponseEntity<>(addressService.updateAddressToRestaurant(address, restaurantId, addressId),
				HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}/{addressId}")
	public ResponseEntity<?> deleteAddressFromUser(@PathVariable Integer userId, @PathVariable Integer addressId)
			throws UserException, AddressException {

		return new ResponseEntity<>(addressService.deleteAddressOfUser(userId, addressId), HttpStatus.OK);
	}

	@DeleteMapping("/restaurant/{restaurantId}/{addressId}")
	public ResponseEntity<?> deleteAddressFromRestaurant(@PathVariable Integer restaurantId,
			@PathVariable Integer addressId) throws RestaurantException, AddressException {

		return new ResponseEntity<>(addressService.deleteAddressOfRestaurant(restaurantId, addressId), HttpStatus.OK);
	}
}
