package com.huytcm.bookstore.dao;

import java.util.List;

import com.huytcm.bookstore.model.Book;

public interface IBookDao {
	
	void insertBook(Book book);
	void updateBook(Book book);
	void deleteBook(Book book);
	
	List<Book> getAllBooks();
	
	Book getBookById(long id);
}
