package com.company.oziva.customer.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.oziva.customer.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	//public Customer findByMobileNo(long customerMobileNo);
	//Optional<Customer> findBycustomerMobileNo(long customerMobileNo);
	
	//below jpa and native sql implementation fetch Customer data along with order details using join
	
//	@Query(value="select c,o from Customer c inner join Orders o on c.customer_mobile_no = o.mobile_no where c.customer_mobile_no= :customerMobileNo", nativeQuery =true)
//	List<Object[]> findBycustomerMobileNo(@Param("customerMobileNo") long customerMobileNo);
	
	
	@Query(value = "SELECT c.id, c.customer_name, o.order_id, o.product_name " +
            "FROM customer c " +
            "INNER JOIN orders o ON c.customer_mobile_no = o.mobile_no " +
            "WHERE c.customer_mobile_no = :customerMobileNo", 
    nativeQuery = true)
	Optional<List<Object[]>> findBycustomerMobileNo(@Param("customerMobileNo") String customerMobileNo);
}
