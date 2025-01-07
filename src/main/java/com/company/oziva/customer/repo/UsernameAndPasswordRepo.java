package com.company.oziva.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.oziva.customer.entity.UsernameAndPassword;

public interface UsernameAndPasswordRepo extends JpaRepository<UsernameAndPassword, String>{

	public UsernameAndPassword findByUserName(String userName);
}
