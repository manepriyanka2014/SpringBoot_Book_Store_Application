package com.bridgelabz.repository;
import com.bridgelabz.model.Book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookStoreRepository extends JpaRepository<Book, Integer> {
	
	public List<Book> findAllByNameStartsWith(String name);
	public List<Book> findAllByBookAuthorNameStartsWith(String bookAuthorName);
	
	
}