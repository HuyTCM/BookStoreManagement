package com.huytcm.bookstore.service;

import java.util.Calendar;

import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.model.User;

public interface IBorrowBookManager {
	
	Boolean userBorrowBook(User user, Book book, Calendar fromDate);
	void userReturnBook(User user, Book book, Calendar date);

}
