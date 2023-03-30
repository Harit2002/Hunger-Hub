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
import com.masai.Exception.ItemException;
import com.masai.Exception.OrderDetailsException;
import com.masai.Exception.UserException;
import com.masai.Model.OrderDetails;
import com.masai.Service.OrderDetailService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
@SecurityRequirement(name = "bearer-key")
public class OrderDetailController {
	
	@Autowired
	OrderDetailService orderService;
	
	@PostMapping("")
	public ResponseEntity<OrderDetails> addItem(@Valid @RequestBody OrderDetails order) throws ItemException, OrderDetailsException {

		return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrderDetails> updateItem(@Valid @RequestBody OrderDetails order, @PathVariable Integer id) throws ItemException, OrderDetailsException {

		return new ResponseEntity<>(orderService.updateOrder(order, id), HttpStatus.ACCEPTED);
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<OrderDetails> viewItem(@PathVariable Integer id) throws OrderDetailsException {

		return new ResponseEntity<>(orderService.viewOrder(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<OrderDetails> deleteItem(@PathVariable Integer id) throws OrderDetailsException {

		return new ResponseEntity<>(orderService.removeOrder(id), HttpStatus.OK);
	}
	
	@GetMapping("customer/{id}")
	public ResponseEntity<List<OrderDetails>> getItemByCustomer(@PathVariable Integer id) throws OrderDetailsException, UserException {

		return new ResponseEntity<>(orderService.viewAllOrdersByCustomer(id), HttpStatus.OK);
	}

}
