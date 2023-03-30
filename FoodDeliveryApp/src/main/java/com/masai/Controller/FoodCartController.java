package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.Exception.FoodCartException;
import com.masai.Exception.ItemException;
import com.masai.Model.FoodCart;
import com.masai.Service.FoodCartService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/cart")

public class FoodCartController {
	
	@Autowired
	FoodCartService cartService;
	
	@SecurityRequirement(name = "bearer-key")
	@PutMapping("/{cartId}")
	public ResponseEntity<FoodCart> addItem(@PathVariable Integer cartId, @RequestParam Integer itemId ) throws ItemException, FoodCartException {

		return new ResponseEntity<>(cartService.addItemToCart(cartId, itemId), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{cartId}")
	public ResponseEntity<FoodCart> addItem(@PathVariable Integer cartId) throws FoodCartException {

		return new ResponseEntity<>(cartService.clearCart(cartId), HttpStatus.CREATED);
		
	}

}
