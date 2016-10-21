package com.huytcm.bookstore.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.huytcm.bookstore.dao.IBookCategoryDao;
import com.huytcm.bookstore.model.BookCategory;

public class BookCategoryDaoImpl extends BaseDaoImpl<BookCategory, Long> implements IBookCategoryDao {

	private static final Logger logger = Logger.getLogger(BookCategoryDaoImpl.class.getName());
	
	@Override
	public void insertBookCategory(BookCategory bookCategory) {
		logger.info("[insertBookCategory] - Start");
		insert(bookCategory);
		logger.info("[insertBookCategory] - End");
	}
	
	@Override
	@Transactional
	public List<BookCategory> getAllBookCategory() {
		logger.info("[getAllBookCategory] - Start");
		List<BookCategory> bookCategories = getAll();
		logger.info("[getAllBookCategory] - End");
		return bookCategories;
	}
	
}
