package com.bridgelabz.dto;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.model.Book;

public class OrderDTO {

	public int customerId;
	public List<Book> orderedBook;
	
}
