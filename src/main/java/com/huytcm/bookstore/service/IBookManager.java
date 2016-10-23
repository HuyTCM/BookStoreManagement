package com.huytcm.bookstore.service;

import java.util.Calendar;
import java.util.List;

import com.huytcm.bookstore.model.Author;
import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.model.BookCategory;

public interface IBookManager {
	List<Book> getAllBook();
	
	void addNewBook(String title, String description, List<Author> authors, List<BookCategory> categories, Calendar publishedDate);
}
