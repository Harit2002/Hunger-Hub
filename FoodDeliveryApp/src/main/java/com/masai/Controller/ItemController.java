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

import com.masai.Exception.CategoryException;
import com.masai.Exception.ItemException;
import com.masai.Exception.RestaurantException;
import com.masai.Model.Item;
import com.masai.Service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	ItemService itemService;

	@PostMapping("")
	public ResponseEntity<Item> addItem(@Valid @RequestBody Item item) throws ItemException {

		return new ResponseEntity<>(itemService.addItem(item), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Item> updateItem(@Valid @RequestBody Item item, @PathVariable Integer id) throws ItemException {

		return new ResponseEntity<>(itemService.updateItem(item, id), HttpStatus.CREATED);
	}
	
	@GetMapping("name/{name}")
	public ResponseEntity<List<Item>> viewItem(@PathVariable String name) throws ItemException {
		
		return new ResponseEntity<>(itemService.viewItemByName(name), HttpStatus.CREATED);
	}
	
	@GetMapping("restaurant/{id}")
	public ResponseEntity<List<Item>> viewItemByRestaurant(@PathVariable Integer restaurantID) throws ItemException, RestaurantException {
		
		return new ResponseEntity<>(itemService.viewItemByRestaurant(restaurantID), HttpStatus.CREATED);
	}
	
	@GetMapping("category/{id}")
	public ResponseEntity<List<Item>> viewItemByCategory(@PathVariable Integer categoryId) throws ItemException, CategoryException {
		
		return new ResponseEntity<>(itemService.viewItemByCategory(categoryId), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Item> deleteItem(@PathVariable Integer id) throws ItemException {
		
		return new ResponseEntity<>(itemService.removeItem(id), HttpStatus.CREATED);
	}
	
	
}
