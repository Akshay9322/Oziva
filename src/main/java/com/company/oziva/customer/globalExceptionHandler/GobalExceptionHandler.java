package com.company.oziva.customer.globalExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.oziva.customer.api.response.ApiResponse;
import com.company.oziva.customer.exception.CustomerNotFoundException;

@RestControllerAdvice
public class GobalExceptionHandler {

	@Autowired
	private ApiResponse apiResponse;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handelValidException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((error) -> {
			
		String fieldName = ((FieldError) error).getField();
		String errorMessage = error.getDefaultMessage();
		
		errors.put(fieldName, errorMessage);
		}
		);
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ApiResponse> handelCustomrNotFoundException(CustomerNotFoundException ex){
		String message = ex.getMessage();
		apiResponse = ApiResponse.builder().message(message).status(HttpStatus.NOT_FOUND).build();
		
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
}
