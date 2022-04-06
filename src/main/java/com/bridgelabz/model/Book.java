package com.bridgelabz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "BOOK_ID")
    private int bookId;
	
	@Column(name = "BOOK_AUTHER_NAME")
    private String bookAuthorName;
    
	@Column(name = "NAME")
    private String name;
    
	@Column(name = "BOOK_IMAGE")
    private String bookImage;
    
	@Column(name = "BOOK_PRICE")
    private String bookPrice;
									
	@Column(name = "BOOK_DESCRIPTION")
    private String bookDescription;
    
}
