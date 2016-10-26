package com.huytcm.bookstore.service;

import java.text.ParseException;
import java.util.List;

import com.huytcm.bookstore.model.Book;

public interface IBookManager {
	List<Book> getAllBook();

	void addNewBook(String title, String description, List<String> authorsId, List<String> categoriesId,
			String publishedDate) throws ParseException;
}
