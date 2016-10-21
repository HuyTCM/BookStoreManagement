package com.huytcm.bookstore.dao;

import java.util.List;

import com.huytcm.bookstore.model.Book;

public interface IBookDao {
	List<Book> getAllBooks();
	
	Book getBookById(long id);
}
