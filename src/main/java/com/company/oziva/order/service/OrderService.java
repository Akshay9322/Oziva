package com.company.oziva.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.oziva.order.entity.Order;
import com.company.oziva.order.exception.MoNumberNotFoundException;
import com.company.oziva.order.exception.OrderNotFoundException;
import com.company.oziva.order.repo.OrderRepo;

@Service
public class OrderService {

	
	@Autowired
	private OrderRepo orderRepo;
	 
	public Order saveOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public List<Order> getOrderByMobileNo(String mobileNo) {
		 
		List<Order> orders = orderRepo
				.findByMobileNo(mobileNo)
				.orElseThrow(() -> new MoNumberNotFoundException("Mobile number not found or customer not registerd with mobile no"+mobileNo));
		
		if(orders.isEmpty()) {
		throw new OrderNotFoundException("Orders not found for customer with mobile no: "+mobileNo);
		}
		return orders;
	}
}
