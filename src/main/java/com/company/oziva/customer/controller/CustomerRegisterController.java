package com.company.oziva.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.oziva.customer.entity.UsernameAndPassword;
import com.company.oziva.customer.service.CustomerService;

@RestController
@RequestMapping("/register")
public class CustomerRegisterController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/user")
	public ResponseEntity<String> registreation(@RequestBody UsernameAndPassword usernameAndPassword) {
		
		if(customerService.exitByUserName(usernameAndPassword.getUserName())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Use unique username");
		}
		
		String response = customerService.registration(usernameAndPassword);
		
		if(response == "User registerd susccesfully") {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		
	}
	
}
