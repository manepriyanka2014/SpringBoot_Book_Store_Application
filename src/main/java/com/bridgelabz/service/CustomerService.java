package com.bridgelabz.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.model.Book;
import com.bridgelabz.model.Customer;
import com.bridgelabz.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomerDetails(CustomerDTO customerDetailsDto) {
		Customer customer = modelMapper.map(customerDetailsDto, Customer.class);
		return customerRepository.save(customer);
	}

	public CustomerDTO getCustomerDetails(String emailId) {
		System.out.println(emailId);
		Optional<Customer> customer = customerRepository.findByEmail(emailId);
		return modelMapper.map(customer.get(), CustomerDTO.class);
	}

}
