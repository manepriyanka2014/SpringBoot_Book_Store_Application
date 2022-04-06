package com.bridgelabz.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Customer;
import com.bridgelabz.service.CartService;
import com.bridgelabz.service.ICartService;

@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CartController {

	@Autowired
	ICartService cartService;

//	@GetMapping("{customerId}/{bookId}/{quantity}")
//	public ResponseEntity<Cart> addToCart(@PathVariable int customerId, @PathVariable int bookId,
//			@PathVariable int quantity) {
//		Cart cart = cartService.add(customerId, bookId, quantity);
//		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	// }

	@PostMapping()
	public ResponseEntity<Customer> add(@RequestBody CustomerDTO customerDTO) {

		Customer customer = cartService.add(customerDTO);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@DeleteMapping("{email}/{bookId}")
	public ResponseEntity<?> delete(@PathVariable("email") String email, @PathVariable("bookId") int bookId) {
		cartService.delete(email, bookId);
		return ResponseEntity.ok().build();
	}
}