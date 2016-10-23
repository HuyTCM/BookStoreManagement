package com.huytcm.bookstore.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.huytcm.bookstore.dao.IUserBorrowBookDao;
import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.model.UserBorrowBook;

public class UserBorrowBookDaoImpl extends BaseDaoImpl<UserBorrowBook, Long> implements IUserBorrowBookDao {

	private static final Logger logger = Logger.getLogger(UserBorrowBookDaoImpl.class.getName());
	
	@Override
	public void insertUserBorrowBook(UserBorrowBook userBorrowBook) {
		logger.info("[insertUserBorrowBook] - Start");
		insert(userBorrowBook);
		logger.info("[insertUserBorrowBook] - End");
	}
	
	@Override
	public void updateUserBorrowBook(UserBorrowBook userBorrowBook) {
		logger.info("[updateUserBorrowBook] - Start: userBorrowBookId = " + userBorrowBook.getId());
		update(userBorrowBook);
		logger.info("[updateUserBorrowBook] - End");
	}
	
	@Override
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
	public UserBorrowBook currentTransitionBook(User user) {
		logger.info("[currentTransitionBook] - Start: userId = " + user.getId());
		Criteria criteria = getSession().createCriteria(UserBorrowBook.class);
		criteria.add(Restrictions.eq("userId", user.getId()));
		criteria.add(Restrictions.eq("isReturned", false));
		UserBorrowBook borrowBook = (UserBorrowBook) criteria.uniqueResult();
		logger.info("[currentTransitionBook] - End");
		return borrowBook;
	}
	
}
