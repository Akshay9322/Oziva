package com.company.oziva.customer.service;


import java.sql.SQLException;
//import java.lang.System.Logger;
import java.util.ArrayList;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.company.oziva.customer.entity.Address;
import com.company.oziva.customer.entity.Customer;
import com.company.oziva.customer.exception.CustomerNotFoundException;
import com.company.oziva.customer.repo.CustomerRepo;
import com.company.oziva.customer.request.dto.CustomerDto;
import com.company.oziva.customer.response.dto.OnlyCustomerResponseDTO;
import com.company.oziva.customer.response.dto.OnlyOrderResponseDTO;


@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	
	public static final Logger logger = LoggerFactory.getLogger(CustomerService.class);
	
//	public CustomerService() { }
//	
//	@Autowired
//	public CustomerService(Customer customer) {
//		this.customer = customer;
//		
//	}
//	
//	@Autowired
//	public CustomerService(Address address) {
//		this.address = address;
//	}
	public CustomerDto saveCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setCustomerName(customerDto.getCustomerName());
		customer.setCustomerMobileNo(customerDto.getCustomerMobileNo());
		customer.setCustomerEmailId(customerDto.getCustomerEmailId());

		Address address = new Address();
		address.setAddress(customerDto.getAddress());
		address.setArea(customerDto.getArea());
		address.setTaluka(customerDto.getTaluka());
		address.setDistrict(customerDto.getDistrict());
		address.setPincode(customerDto.getPincode());
		address.setCustomer(customer);
		
		customer.setCustomerAddress(address);
		
		
		customerRepo.save(customer);
		
		return customerDto;
		
	}
	
//	public CustomerResponseDTO getCustomerWithAddress(long customerMobileNo) {
//		
//	    customerResponseDTO.setCustomer(customerRepo.findBycustomerMobileNo(customerMobileNo));
//	    customerResponseDTO.setOrder(orderRepo.findBymobileNo(customerMobileNo));
//		return customerResponseDTO;
//	}
	
	public  List<OnlyCustomerResponseDTO> getcustomerAndOrder(String customerMobileNo) {
		
	           
	 List<Object[]> rows = customerRepo.findBycustomerMobileNo(customerMobileNo);
	 
	 Map<Long, OnlyCustomerResponseDTO> customerOrder = new HashMap<>();
	 //map will store customerId and there customer object
	 
	 for(Object[] row : rows) {
		 long customerId = (long) row[0];
		 String custmerName = (String) row[1];
		 
		 long orderId = (long) row[2];
		 String productName = (String) row[3];
		 
		 
		 
		OnlyCustomerResponseDTO onlyCustomerResponseDTO = customerOrder.get(customerId);
		 
		// logger.debug(onlyCustomerResponseDTO.getListOfOrder().get(3).getProductName());
		 
		 if(onlyCustomerResponseDTO == null) {
			 onlyCustomerResponseDTO = new OnlyCustomerResponseDTO();
			 System.out.println("Valoue of object After: "+onlyCustomerResponseDTO);
			 onlyCustomerResponseDTO.setId(customerId);
			 onlyCustomerResponseDTO.setName(custmerName);
			 onlyCustomerResponseDTO.setListOfOrder(new ArrayList<>());
			 customerOrder.put(customerId, onlyCustomerResponseDTO);
		 }
		 
		 OnlyOrderResponseDTO onlyOrderResponseDTO = new OnlyOrderResponseDTO();
		 
		 onlyOrderResponseDTO.setId(orderId);
		 onlyOrderResponseDTO.setProductName(productName);
		 
		 onlyCustomerResponseDTO.getListOfOrder().add(onlyOrderResponseDTO);
	 }
	 
    
	return new ArrayList<>(customerOrder.values());
	}
	
	public OnlyCustomerResponseDTO fetchSingleCustomer(String mobileNo) {
		List<Object[]> rows;
		try {
		 rows = customerRepo.findBycustomerMobileNo(mobileNo);
		}catch(DataAccessException  ex){
			logger.error("Database failed to fetch data", ex);
			throw new RuntimeException("Database failed to fetch data",ex);
		}
		
		if(rows.isEmpty()) {
			 throw new CustomerNotFoundException("No cutomer found");
		}
		
		
		
		Object[] firstRow = rows.get(0);
		
		long customerId = (long) firstRow[0];
		String customername = (String) firstRow[1];
		
		OnlyCustomerResponseDTO onlyCustomerResponseDTO  = new OnlyCustomerResponseDTO();
		
		onlyCustomerResponseDTO.setId(customerId);
		onlyCustomerResponseDTO.setName(customername);
		onlyCustomerResponseDTO.setListOfOrder(new ArrayList<>());
		
		
		
		for(Object[] row : rows) {
			long orderId = (long) row[2];
			String productName = (String) row[3];
			
			OnlyOrderResponseDTO onlyOrderResponseDTO = new OnlyOrderResponseDTO();
			onlyOrderResponseDTO.setId(orderId);
			onlyOrderResponseDTO.setProductName(productName);
			
			onlyCustomerResponseDTO.getListOfOrder().add(onlyOrderResponseDTO);
		
			
		}
		
		return onlyCustomerResponseDTO;
	}
	
	

}
