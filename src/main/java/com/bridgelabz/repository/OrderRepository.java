package com.bridgelabz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	

}
