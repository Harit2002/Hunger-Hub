package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyErrorDetails> userExceptionHandler(UserException user, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(user.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ItemException.class)
	public ResponseEntity<MyErrorDetails> itemExceptionHandler(ItemException item, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(item.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> categoryExceptionHandler(CategoryException category, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(category.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FoodCartException.class)
	public ResponseEntity<MyErrorDetails> foodCartExceptionHandler(FoodCartException food, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(food.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OrderDetailsException.class)
	public ResponseEntity<MyErrorDetails> orderDetailsExceptionHandler(OrderDetailsException order, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(order.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrorDetails> addressExceptionHandler(AddressException add, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(add.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BillException.class)
	public ResponseEntity<MyErrorDetails> billExceptionHandler(BillException bill, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(bill.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> allExceptionHandler(Exception ex, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(ex.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> addressExceptionHandler(NoHandlerFoundException nhf, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(nhf.getMessage());
		details.setErrorDetails(req.getDescription(false));

		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage("Validation Error");
		details.setErrorDetails(me.getBindingResult().getFieldError().getDefaultMessage());
				
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(RestaurantException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(RestaurantException res, WebRequest req) {

		MyErrorDetails details = new MyErrorDetails();
		details.setTimeStamp(LocalDateTime.now());
		details.setMessage(res.getMessage());
		details.setErrorDetails(req.getDescription(false));
				
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);

	}

}
