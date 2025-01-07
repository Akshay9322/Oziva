package com.company.oziva.order.gobalExceptionHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.oziva.order.api.response.ApiOrderResponse;
import com.company.oziva.order.exception.MoNumberNotFoundException;
import com.company.oziva.order.exception.OrderNotFoundException;

@RestControllerAdvice
public class GobalOrderExceptionHandler {
	
	@Autowired
	private ApiOrderResponse apiResponse;
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ApiOrderResponse> orderNotFoundExceptionHandler(OrderNotFoundException ex) {
		System.out.println("message: "+ex.getMessage());
		apiResponse = ApiOrderResponse.builder().message(ex.getMessage()).build();
		
		return new ResponseEntity<ApiOrderResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MoNumberNotFoundException.class)
	public ResponseEntity<ApiOrderResponse> moNumberNotFoundExceptionHnadler(MoNumberNotFoundException ex){
		apiResponse = ApiOrderResponse.builder().message(ex.getMessage()).build();
	    return new 	ResponseEntity<ApiOrderResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

}
