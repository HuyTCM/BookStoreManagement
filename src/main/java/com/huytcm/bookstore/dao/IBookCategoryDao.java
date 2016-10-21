package com.huytcm.bookstore.dao;

import java.util.List;

import com.huytcm.bookstore.model.BookCategory;

public interface IBookCategoryDao {
	
	void insertBookCategory(BookCategory bookCategory);
	
	List<BookCategory> getAllBookCategory();
}
