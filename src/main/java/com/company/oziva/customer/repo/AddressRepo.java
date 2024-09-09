package com.company.oziva.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.oziva.customer.entity.Address;

public interface AddressRepo extends JpaRepository<Address,Long> {

}
