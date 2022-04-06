package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Customer;

public interface ICartService {
//	 public Cart addCart(int userId, int bookId, Long quantity);

	public Customer add(CustomerDTO customerDTO) ;

	public void delete(String emailId,int bookId);
	
	

}		