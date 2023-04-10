package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@SecurityRequirement(name = "bearer-key")
public class FoodCartController {
	
	@Autowired
	FoodCartService cartService;

	@PutMapping("/{cartId}")
	public ResponseEntity<FoodCart> addItem(@PathVariable Integer cartId, @RequestParam Integer itemId ) throws ItemException, FoodCartException {

		return new ResponseEntity<>(cartService.addItemToCart(cartId, itemId), HttpStatus.CREATED);
	}
	
	@PutMapping("inc/{cartId}")
	public ResponseEntity<FoodCart> updateItemQuantity(@PathVariable Integer cartId, @RequestParam Integer itemId, @RequestParam Integer quat ) throws ItemException, FoodCartException {

		return new ResponseEntity<>(cartService.increaseQuantiity(cartId, itemId, quat), HttpStatus.CREATED);
	}
	
	@PutMapping("dec/{cartId}")
	public ResponseEntity<FoodCart> decreseItemQuantity(@PathVariable Integer cartId, @RequestParam Integer itemId, @RequestParam Integer quat ) throws ItemException, FoodCartException {

		return new ResponseEntity<>(cartService.reduceQuantity(cartId, itemId, quat), HttpStatus.CREATED);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{cartId}")
	public ResponseEntity<FoodCart> celarItemList(@PathVariable Integer cartId) throws FoodCartException {

		return new ResponseEntity<>(cartService.clearCart(cartId), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("delete/{cartId}")
	public ResponseEntity<FoodCart> deleteItem(@PathVariable Integer cartId, @RequestParam Integer itemId ) throws ItemException, FoodCartException {

		return new ResponseEntity<>(cartService.removeItem(cartId, itemId), HttpStatus.CREATED);
	}

}
