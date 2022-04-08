package com.bridgelabz.service;

import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.dto.OrderDTO;
import com.bridgelabz.model.Customer;
import com.bridgelabz.model.Order;

public interface IOrderService {

	
	public Order addOrderDetails(OrderDTO orderdto) ;
	
}
