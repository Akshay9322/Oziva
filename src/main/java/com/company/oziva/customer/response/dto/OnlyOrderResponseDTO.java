package com.company.oziva.customer.response.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlyOrderResponseDTO {

	private long id;
	private String productName;
}
