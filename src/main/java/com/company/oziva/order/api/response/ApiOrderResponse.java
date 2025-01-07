package com.company.oziva.order.api.response;

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

public class ApiOrderResponse {
	
	private String message;
	
	

}
