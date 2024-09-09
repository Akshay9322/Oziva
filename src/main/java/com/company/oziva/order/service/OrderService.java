package com.company.oziva.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.oziva.order.entity.Order;
import com.company.oziva.order.repo.OrderRepo;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepo orderRepo;
	
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
}
