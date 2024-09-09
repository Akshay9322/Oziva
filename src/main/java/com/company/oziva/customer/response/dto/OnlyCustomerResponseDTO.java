package com.company.oziva.customer.response.dto;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

public class OnlyCustomerResponseDTO {
	
	private long id;
	
	private String name;
	
	private List<OnlyOrderResponseDTO> listOfOrder;
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OnlyCustomerResponseDTO that = (OnlyCustomerResponseDTO) o;
        return id == that.id &&
               Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
    
    public String display() {
    	return "Hello from display()";
    }

}
