package com.huytcm.bookstore.dao;

import java.util.List;

import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.model.UserBorrowBook;

public interface IUserBorrowBookDao {
	
	void insertUserBorrowBook(UserBorrowBook userBorrowBook);
	void updateUserBorrowBook(UserBorrowBook userBorrowBook);
	
	List<UserBorrowBook> getBorrowedTransitionByUser(User user);
	
	UserBorrowBook currentTransitionBook(User user);

}
