package com.huytcm.bookstore.service;

import java.util.List;

import com.huytcm.bookstore.model.BookCategory;

public interface IBookCategoryManager {
	
	BookCategory bookCategoryById(String id);
	List<BookCategory> getAllBookCategory();
}
