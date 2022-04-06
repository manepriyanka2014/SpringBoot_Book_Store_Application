package com.bridgelabz.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Customer;
import com.bridgelabz.repository.BookStoreRepository;
import com.bridgelabz.repository.CustomerRepository;

@Service
public class CartService implements ICartService {

	@Autowired
	ModelMapper modelMapper;

//	@Autowired
//	private CartRepository cartRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BookStoreRepository bookStoreRepository;

//	public Cart add(int customerId, int bookId, int quantity) {
//		Cart cart = cartRepository.findCartByBookIDAndCustomerID(bookId, customerId);
//		if (cart == null) {
//			// to save new entry in cart table
//			cart = new Cart(customerId,bookId, quantity);
//			cartRepository.save(cart);
//
//		} else {
//			// to update quantity of existing cart
//			cart.setQuantity(quantity);
//			cartRepository.save(cart);
//		} 
//
//		return cart;
//	}

	public Customer add(CustomerDTO customerDTO) {

		Optional<Customer> customer = customerRepository.findByEmail(customerDTO.getEmail());
		if (!customer.isPresent()) {
		
			Customer newCustomer = modelMapper.map(customerDTO, Customer.class);
			//newCustomer.getCartBook().addAll(books);
			customer = Optional.of(newCustomer);

		}
		return customerRepository.save(customer.get());

	}

	@Override
	public void delete(String emailId , int bookId) {
		
		Optional<Customer> customer = customerRepository.findByEmail(emailId);
		if (customer.isPresent()) {
				    
			Book book1 = customer.get().getCartBook().stream().filter(book->book.getBookId()==bookId).findFirst().get();
			
			customer.get().getCartBook().remove(book1);

			
		}
		customerRepository.save(customer.get());

	}

}
