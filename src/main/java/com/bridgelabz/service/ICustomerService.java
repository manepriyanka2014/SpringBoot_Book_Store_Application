package com.bridgelabz.service;

import com.bridgelabz.dto.CustomerDTO;
import com.bridgelabz.model.Customer;

public interface ICustomerService {

	public Customer addCustomerDetails(CustomerDTO customerDetailsDto);

	public CustomerDTO getCustomerDetails(String emailId);
}
