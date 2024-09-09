package com.company.oziva.customer.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String address;
	
	private String area;
	
	private String taluka;
	
	private String district;
	 
	private String pincode;
	
	@OneToOne
	@JoinColumn(name = "customer_mobile_no", referencedColumnName = "customerMobileNo")
	@JsonBackReference
	private Customer customer;
}
