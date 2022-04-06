package com.bridgelabz.service;

import java.util.List;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bridgelabz.*;
import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.exceptionHandler.UserNotFoundException;
import com.bridgelabz.model.Book;
import com.bridgelabz.repository.BookStoreRepository;

@Service
public class BookStoreService implements IBookStoreService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	private BookStoreRepository bookStoreRepository;

	@Override
	public List<Book> getAllBookDetails() {
		return bookStoreRepository.findAll();
	}

	@Override
	public void deleteBookDetails(int bookid) {
		bookStoreRepository.deleteById(bookid);

	}

	@Override
	public Book addBookDetails(BookDetailsDTO bookDetailsDto) {
		Book book = modelMapper.map(bookDetailsDto, Book.class);
		return bookStoreRepository.save(book);
	}

	@Override
	public List<Book> bookSearch(String name) {
		if (bookStoreRepository.findAllByNameStartsWith(name) != null) {
			return bookStoreRepository.findAllByNameStartsWith(name);
		} else {
			return null;
		}
	}
	
	public List<Book> searchAuther(String bookAuthorName){
	if (bookStoreRepository.findAllByBookAuthorNameStartsWith(bookAuthorName) != null) {
		return bookStoreRepository.findAllByBookAuthorNameStartsWith(bookAuthorName);
	} else {
		return null;
	}
	}

	@Override
	public Book updateBookDetails(int bookId, BookDetailsDTO bookDetailsDto) {
		Book bookDb = bookStoreRepository.getById(bookId);
		if (bookDb != null) {

			if (Objects.nonNull(bookDetailsDto.getName()) && bookDetailsDto.getName() != "") {
				bookDb.setName(bookDetailsDto.getName());
			}

			if (Objects.nonNull(bookDetailsDto.getBookAuthorName()) && bookDetailsDto.getBookAuthorName() != "") {
				bookDb.setBookAuthorName(bookDetailsDto.getBookAuthorName());
			}

			if (Objects.nonNull(bookDetailsDto.getBookPrice()) && bookDetailsDto.getBookPrice() != "") {
				bookDb.setBookPrice(bookDetailsDto.getBookPrice());
			}

			if (Objects.nonNull(bookDetailsDto.getBookDescription())) {
				bookDb.setBookDescription(bookDetailsDto.getBookDescription());
			}

		    return bookStoreRepository.save(bookDb);
		}

		return null;
	}

}
