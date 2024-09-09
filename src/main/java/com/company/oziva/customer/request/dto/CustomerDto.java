package com.company.oziva.customer.request.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
 /* this customer dto class will have client data that is customer and there address data */
	 
	//customer specific data fields
	private String customerName;
     
	@Email
	private String customerEmailId;

	@Pattern(regexp = "^\\d{10}$", message = "Mobile number must be exactly 10 digits long.")
	private String customerMobileNo;

	// address specific field
	private String address;

	private String area;

	private String taluka;

	private String district;

	@Size(min = 6 , max = 6, message= "pincode size dosen't match")
	private String pincode;
	
}
