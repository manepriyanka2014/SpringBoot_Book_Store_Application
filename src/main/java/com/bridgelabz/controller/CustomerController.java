package com.bridgelabz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Customer;
import com.bridgelabz.service.IBookStoreService;
import com.bridgelabz.service.ICustomerService;

@RestController
@RequestMapping(value = "/customer-details")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	
	@Autowired
    private ICustomerService customerService ;
	
	@PostMapping("/customer")
	public ResponseEntity<?> addCustomerDetails(@RequestBody CustomerDTO customerDetailsDto) {
		Customer customer = customerService.addCustomerDetails(customerDetailsDto);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/customer")
	public ResponseEntity<?> getCustomerDetails(@RequestParam String email) {
		CustomerDTO customer = customerService.getCustomerDetails(email);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
}
