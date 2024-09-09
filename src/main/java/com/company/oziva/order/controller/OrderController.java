package com.company.oziva.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.oziva.order.entity.Order;
import com.company.oziva.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping("/hello")
	public String helloOrder() {
		return "hello order";
	}
	
	@PostMapping("/save")
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(order));
	}
}
