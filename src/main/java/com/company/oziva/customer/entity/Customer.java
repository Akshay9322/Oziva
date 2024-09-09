package com.company.oziva.customer.entity;



import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   private String customerName;
   
   @Column(unique = true)
   private String customerEmailId;
   
   @Column(unique = true)
   private String customerMobileNo;
   
   @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
   @JsonManagedReference
   private Address customerAddress;
   
}
