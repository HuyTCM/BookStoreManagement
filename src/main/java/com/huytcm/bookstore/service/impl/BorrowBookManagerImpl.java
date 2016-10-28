package com.huytcm.bookstore.service.impl;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytcm.bookstore.dao.IUserBorrowBookDao;
import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.model.UserBorrowBook;
import com.huytcm.bookstore.service.IBookManager;
import com.huytcm.bookstore.service.IBorrowBookManager;

@Service
public class BorrowBookManagerImpl implements IBorrowBookManager {

	private static final Logger logger = Logger.getLogger(BorrowBookManagerImpl.class.getName());

	@Autowired
	IBookManager bookManager;
	
	@Autowired
	IUserBorrowBookDao userBorrowBookDao;

	@Override
	public Boolean userBorrowBook(User user, Book book, Calendar fromDate) {
		logger.info("[userBorrowBook] - Start: userId = " + user.getId() + ", bookId = " + book.getId());
		// get current transition if any
		UserBorrowBook userBorrowedBook = userBorrowBookDao.currentTransitionBook(user);
		if (userBorrowedBook != null) {
			// can't borrow book
			// A user can borrow only one book at a time
			return false;
		}
		userBorrowedBook = new UserBorrowBook();

		userBorrowedBook.setBookId(book.getId());
		userBorrowedBook.setUserId(user.getId());
		userBorrowedBook.setBorrowedDate(fromDate);
		userBorrowedBook.setIsReturned(false);

		userBorrowBookDao.insertUserBorrowBook(userBorrowedBook);
		logger.info("[userBorrowBook] - End");
		return true;
	}
	
	@Override
	public void userReturnBook(User user, Book book, Calendar date) {
		logger.info("[userReturnBook] - Start: userId = " + user.getId() + ", bookId = " + book.getId());
		UserBorrowBook currTransition = userBorrowBookDao.currentTransitionBook(user);
		if (currTransition == null) {
			return;
		}
		currTransition.setIsReturned(true);
		if (date != null) {
			currTransition.setReturnDate(date);
		}
		
		int currTransit = book.getNumOfBorrowed();
		currTransit++;
		book.setNumOfBorrowed(currTransit);
		bookManager.updateBook(book);
		
		userBorrowBookDao.updateUserBorrowBook(currTransition);
		
		logger.info("[userReturnBook] - End");
	}

	@Override
	public List<UserBorrowBook> getAllBorrowHistoryByUser(User user) {
		logger.info("[getAllBorrowHistoryByUser] - Start: userId = " + user.getId());
		List<UserBorrowBook> history = userBorrowBookDao.getBorrowedTransitionByUser(user);
		logger.info("[getAllBorrowHistoryByUser] - End");
		return history;
	}
	
	@Override
	public List<UserBorrowBook> getAll() {
		List<UserBorrowBook> listBorrow = userBorrowBookDao.getAll();
		return listBorrow;
	}
}
