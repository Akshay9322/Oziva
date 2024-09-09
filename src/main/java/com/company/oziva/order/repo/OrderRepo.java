package com.company.oziva.order.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.company.oziva.order.entity.Order;

public interface OrderRepo extends CrudRepository<Order, Long> {

	Optional<Order> findBymobileNo(String mobileNo);
}
