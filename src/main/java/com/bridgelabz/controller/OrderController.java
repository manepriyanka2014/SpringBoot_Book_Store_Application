package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.dto.OrderDTO;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Order;
import com.bridgelabz.service.ICartService;
import com.bridgelabz.service.IOrderService;

@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OrderController {

	@Autowired
	IOrderService orderService;
	
	@PostMapping()
	public ResponseEntity<Order> add(@RequestBody OrderDTO OrderDto) {
		System.out.println("OrderDto" + OrderDto);

		Order order = orderService.addOrderDetails(OrderDto);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	@GetMapping()
	public String demo() {
		return "Working Fine";
	}
	
}
