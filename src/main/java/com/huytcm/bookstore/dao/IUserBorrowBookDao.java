package com.huytcm.bookstore.dao;

import java.util.List;

import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.model.UserBorrowBook;

public interface IUserBorrowBookDao {
	
	void insertUserBorrowBook(UserBorrowBook userBorrowBook);
	void updateUserBorrowBook(UserBorrowBook userBorrowBook);
	
	List<UserBorrowBook> getBorrowedTransitionByUser(User user);
	List<UserBorrowBook> getAll();
	
	UserBorrowBook currentTransitionBook(User user);
	UserBorrowBook currentTransitionOfBook(Book book);

}
