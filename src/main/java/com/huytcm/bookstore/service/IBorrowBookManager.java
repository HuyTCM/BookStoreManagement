package com.huytcm.bookstore.service;

import java.util.Calendar;
import java.util.List;

import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.model.UserBorrowBook;

public interface IBorrowBookManager {
	
	Boolean userBorrowBook(User user, Book book, Calendar fromDate);
	void userReturnBook(User user, Book book, Calendar date);
	
	List<UserBorrowBook> getAllBorrowHistoryByUser(User user);

}
