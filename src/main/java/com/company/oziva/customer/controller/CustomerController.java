package com.company.oziva.customer.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.oziva.customer.request.dto.CustomerDto;
import com.company.oziva.customer.response.dto.CustomerResponseDTO;
import com.company.oziva.customer.response.dto.OnlyCustomerResponseDTO;
import com.company.oziva.customer.response.dto.OnlyOrderResponseDTO;
import com.company.oziva.customer.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/hello")
	public String helloCustomer() {
		return "Hello customer";
	}
	
	@PostMapping("/save")
	public ResponseEntity<CustomerDto> saveCustomer(@ Valid @RequestBody CustomerDto customerDto){
        System.out.println("Name of customer"+customerDto.getCustomerName());
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customerDto));
		
	}
	
	@GetMapping("/fetch/{mobileNo}")
	public ResponseEntity<List<OnlyCustomerResponseDTO>> getCustomer(@PathVariable String mobileNo){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.getcustomerAndOrder(mobileNo));
	}
	
	@GetMapping("/fetch/single/{mobileNo}")
	public ResponseEntity<OnlyCustomerResponseDTO> getSingleCustomer(@PathVariable String mobileNo){
		return ResponseEntity.status(HttpStatus.FOUND).body(customerService.fetchSingleCustomer(mobileNo));
	}
	
}
