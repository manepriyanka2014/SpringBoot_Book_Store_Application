package com.bridgelabz.service;

import com.bridgelabz.dto.BookDetailsDTO;


import com.bridgelabz.model.Book;

import java.util.List;

public interface IBookStoreService {

	 List<Book> getAllBookDetails();
	 
	 List<Book> bookSearch(String name);
	 
	 List<Book> searchAuther(String bookAuthorName);
  
   public void deleteBookDetails(int id);

   public Book addBookDetails(BookDetailsDTO bookDetailsDto);

   public Book updateBookDetails(int bookId,BookDetailsDTO bookDetailsDto);

}
	

