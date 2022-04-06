package com.bridgelabz.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.bridgelabz.model.Book;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerDTO {
	
	@NotNull(message = "Customer name should not be empty")
	private String name;
	
	private String email;

	@NotNull(message = "phoneNumber should not be empty")
	private String phoneNumber;

	@NotNull(message = "pinCode should not be empty")
	private String pinCode;
	
	@NotNull(message = "address should not be empty")
	private String address;
	
	@NotNull(message = "city should not be empty")
	private String city;
	
	@NotNull(message = "addressType should not be empty")
	private String addressType;
	
	private List<Book> cartBook;
		
}
