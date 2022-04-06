package com.bridgelabz.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDetailsDTO {

	@NotNull(message = "Book name should not be empty")
	private String name;

	@NotNull(message = "Author name should not be empty")
	private String bookAuthorName;

	@NotNull(message = "Image should not be empty")
	private String bookImage;

	@NotNull(message = "Price should not be empty")
	private String bookPrice;

	@NotNull(message = "Description should not be empty")
	private String bookDescription;



}
