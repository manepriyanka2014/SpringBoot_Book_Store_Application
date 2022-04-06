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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.exceptionHandler.UserNotFoundException;
import com.bridgelabz.model.Book;
import com.bridgelabz.service.IBookStoreService;


@RestController
@RequestMapping(value = "/book-store")
@CrossOrigin(origins = "http://localhost:3000")
public class BookStoreController {

	
	@Autowired
    private IBookStoreService bookStoreService;
	
	@PostMapping("/book")
	public ResponseEntity<?> addBook(@RequestBody BookDetailsDTO BookDetailsDto) {
		Book book = bookStoreService.addBookDetails(BookDetailsDto);
		return new ResponseEntity<>(book, HttpStatus.OK);
	}
	
	@GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBookDetails() {
        return new ResponseEntity<>(bookStoreService.getAllBookDetails(),HttpStatus.OK);
    }
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteBookDetails( @PathVariable("id") int bookId) {
		bookStoreService.deleteBookDetails(bookId);
		return ResponseEntity.ok().build();
	}

	//for update book
	@PutMapping("/book/{id}")
	public ResponseEntity<Book> updateBookDetails(@RequestBody BookDetailsDTO bookDetailsDTO,
			@PathVariable("id") int BookId) throws UserNotFoundException {
		Book BookDB = bookStoreService.updateBookDetails(BookId, bookDetailsDTO);
		return new ResponseEntity<Book>(BookDB, HttpStatus.OK);
	}
	
	//for search book
	@GetMapping("/book/search/{name}")
	public ResponseEntity<?> searchBookByName(@PathVariable String name){
		List<Book> bookListDB= bookStoreService.bookSearch(name);
		return new ResponseEntity<>(bookListDB, HttpStatus.OK);
	}

// for search Author Name
@GetMapping("/book/authorSearch/{bookAuthorName}")
public ResponseEntity<?> searchAuther(@PathVariable String bookAuthorName){
	List <Book> bookListDB= bookStoreService.searchAuther(bookAuthorName);
	return new ResponseEntity<> (bookListDB, HttpStatus.OK);
}
}



