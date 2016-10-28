package com.huytcm.bookstore.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.huytcm.bookstore.dao.IUserBorrowBookDao;
import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.model.UserBorrowBook;

@Repository
public class UserBorrowBookDaoImpl extends BaseDaoImpl<UserBorrowBook, Long> implements IUserBorrowBookDao {

	private static final Logger logger = Logger.getLogger(UserBorrowBookDaoImpl.class.getName());
	
	public UserBorrowBookDaoImpl (Class<UserBorrowBook> clazz) {
		super(clazz);
	}
	
	public UserBorrowBookDaoImpl() {
		setClazz(UserBorrowBook.class);
	}
	
	@Override
	@Transactional
	public void insertUserBorrowBook(UserBorrowBook userBorrowBook) {
		logger.info("[insertUserBorrowBook] - Start");
		insert(userBorrowBook);
		logger.info("[insertUserBorrowBook] - End");
	}
	
	@Override
	@Transactional
	public void updateUserBorrowBook(UserBorrowBook userBorrowBook) {
		logger.info("[updateUserBorrowBook] - Start: userBorrowBookId = " + userBorrowBook.getId());
		update(userBorrowBook);
		logger.info("[updateUserBorrowBook] - End");
	}
	
	@Override
	@Transactional
	public List<UserBorrowBook> getBorrowedTransitionByUser(User user) {
		logger.info("[getBookIDBorrowedByUser] - Start: userId = " + user.getId());
		Criteria criteria = getSession().createCriteria(UserBorrowBook.class);
		criteria.add(Restrictions.eq("userId", user.getId()));
		@SuppressWarnings("unchecked")
		List<UserBorrowBook> results = criteria.list();
		logger.info("[getBookIDBorrowedByUser] - End");
		return results;
	}
	
	@Override
	@Transactional
	public List<UserBorrowBook> getAll() {
		return super.getAll();
	}
	
	@Override
	@Transactional
	public UserBorrowBook currentTransitionBook(User user) {
		logger.info("[currentTransitionBook] - Start: userId = " + user.getId());
		Criteria criteria = getSession().createCriteria(UserBorrowBook.class);
		criteria.add(Restrictions.eq("userId", user.getId()));
		criteria.add(Restrictions.eq("isReturned", false));
		UserBorrowBook borrowBook = (UserBorrowBook) criteria.uniqueResult();
		logger.info("[currentTransitionBook] - End");
		return borrowBook;
	}
	
	@Override
	@Transactional
	public UserBorrowBook currentTransitionOfBook(Book book) {
		logger.info("[currentTransitionBook] - Start: bookId = " + book.getId());
		Criteria criteria = getSession().createCriteria(UserBorrowBook.class);
		criteria.add(Restrictions.eq("bookId", book.getId()));
		criteria.add(Restrictions.eq("isReturned", false));
		UserBorrowBook bookIsBorrowed = (UserBorrowBook) criteria.uniqueResult();
		logger.info("[currentTransitionBook] - End");
		return bookIsBorrowed;
	}
}
