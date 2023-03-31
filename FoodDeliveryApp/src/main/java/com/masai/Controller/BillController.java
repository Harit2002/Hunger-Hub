package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.BillException;
import com.masai.Model.Bill;
import com.masai.Service.BillService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bills")
public class BillController {

	@Autowired
	private BillService billservice;

	@PostMapping
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) {
		
		return new ResponseEntity<>(billservice.addBill(bill),HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Bill> updateBill(@PathVariable(value="id")Integer id,@Valid @RequestBody Bill bill) throws BillException{
		
		Bill updatedBill = billservice.updateBill(id,bill);
		
		return new ResponseEntity<>(updatedBill,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Bill>removeBill(@PathVariable(value="id")Integer id)throws BillException{
		
		Bill deletedBill = billservice.removeBill(id);
		
		return new ResponseEntity<>(deletedBill,HttpStatus.OK);
		
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Bill>viewBill(@PathVariable(value="id")Integer id)throws BillException{
		
		Bill bill = billservice.viewBill(id);
		
		return new ResponseEntity<>(bill,HttpStatus.OK);
		
	}
	
	


}
