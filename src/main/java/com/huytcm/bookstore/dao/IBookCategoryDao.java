package com.huytcm.bookstore.dao;

import java.util.List;

import com.huytcm.bookstore.model.BookCategory;

public interface IBookCategoryDao {
	
	void insertBookCategory(BookCategory bookCategory);
	void updateBookCategory(BookCategory bookCategory);
	
	BookCategory getCategoryById(long id);
	List<BookCategory> getAllBookCategory();
}
