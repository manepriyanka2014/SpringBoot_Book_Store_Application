package com.bridgelabz.service;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.service.IOrderService;
import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.dto.OrderDTO;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Order;
import com.bridgelabz.repository.CustomerRepository;
import com.bridgelabz.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	OrderRepository orderRepository;

	@Override
	public Order addOrderDetails(OrderDTO orderdto) {
		Optional<Customer> customer = customerRepository.findById(orderdto.customerId);
		if (customer.isPresent()) {
		
			Order newOrder = modelMapper.map(orderdto, Order.class);
			newOrder.setCustomer(customer.get());
			return orderRepository.save(newOrder);
			
		}
		return null;

	}
}

	
//	public Order addOrderDetails(OrderDTO orderdto) {
//		
//		Optional<Order> order = customerRepository.findByEmail(customerDTO.getEmail());
//		if (!customer.isPresent()) {
//		
//			Customer newCustomer = modelMapper.map(customerDTO, Customer.class);
//			//newCustomer.getCartBook().addAll(books);
//			customer = Optional.of(newCustomer);
//
//		}
//		return customerRepository.save(customer.get());
//
//	}
//
//	}


	


