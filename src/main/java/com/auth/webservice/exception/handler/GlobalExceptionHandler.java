package com.auth.webservice.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.auth.webservice.exception.CustomerNotFound;
import com.auth.webservice.exception.EmployeeNotFound;
import com.auth.webservice.exception.InvalidTokenException;
import com.auth.webservice.exception.OrderNotFound;
import com.auth.webservice.exception.ProductNotFoundexception;
import com.auth.webservice.exception.UserAlreadyExistException;



@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> customerEmtyValueError(MethodArgumentNotValidException exception) {
		ExceptionResponse errorDetails = new ExceptionResponse("Validation Error", new Date(),
				HttpStatus.NOT_FOUND.name(), exception.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ProductNotFoundexception.class)
	public ResponseEntity<ExceptionResponse> productNotFoundexception(ProductNotFoundexception exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = CustomerNotFound.class)
	public ResponseEntity<ExceptionResponse> customerNotFoundexception(CustomerNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = OrderNotFound.class)
	public ResponseEntity<ExceptionResponse> orderNotFoundexception(OrderNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = EmployeeNotFound.class)
	public ResponseEntity<ExceptionResponse> employeeNotFoundexception(EmployeeNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<ExceptionResponse> userAlreadyExistException(UserAlreadyExistException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.BAD_REQUEST.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = InvalidTokenException.class)
	public ResponseEntity<ExceptionResponse> invalidTokenException(InvalidTokenException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.UNAUTHORIZED.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.UNAUTHORIZED);
	}


}
