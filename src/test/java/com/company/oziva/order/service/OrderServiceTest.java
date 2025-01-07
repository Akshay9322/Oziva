//package com.company.oziva.order.service;
//
//import static org.mockito.Mockito.when;
//
//import java.sql.Date;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.ActiveProfiles;
//
//import com.company.oziva.order.entity.Order;
//import com.company.oziva.order.repo.OrderRepo;
//
//@SpringBootTest
//@ActiveProfiles("test") // Activate the 'test' profile
//public class OrderServiceTest {
//	
//	@Autowired
//	private OrderRepo orderRepo;
//	
//	@InjectMocks
//	private OrderService orderService;
//	
//	@Test
//	public void getOrderByMobileNoTest() {
//		String mobileNo = "8652378898";
//		Order order = new Order();
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		
//		java.util.Date utilDate;
//		try {
//			utilDate = dateFormat.parse("2024-10-03");
//			// Convert java.util.Date to java.sql.Date
//			Date sqlDate = new Date(utilDate.getTime());
//			order.setOrderDate(sqlDate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		order.setOrderId(1);
//		order.setMobileNo("8652378898");
//		order.setProductName("Plant protine");
//		order.setProductPrice("1500");
//		
//		List<Order> actualOrder = new ArrayList<>();
//		
//		actualOrder.add(order);
//		
//		List<Order> expectedOrders = orderService.getOrderByMobileNo(mobileNo);
//		
////		assertEquals(actualOrder.size(), expectedOrders.size());
//
//	}
//
//}
