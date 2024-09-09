package com.company.oziva.customer.api.response;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
	
	private String message;
	private HttpStatus status;

}
