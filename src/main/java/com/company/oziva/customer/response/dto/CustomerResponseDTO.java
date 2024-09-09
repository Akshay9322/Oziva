package com.company.oziva.customer.response.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.company.oziva.customer.entity.Customer;
import com.company.oziva.order.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

	
	private Customer customer;
	
	private List<Order> order;
	
	private List<OnlyCustomerResponseDTO> onlyCustomerResponseDTO;
	
}
