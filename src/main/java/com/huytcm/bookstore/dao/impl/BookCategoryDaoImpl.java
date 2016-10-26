package com.huytcm.bookstore.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.huytcm.bookstore.dao.IBookCategoryDao;
import com.huytcm.bookstore.model.BookCategory;

@Repository
public class BookCategoryDaoImpl extends BaseDaoImpl<BookCategory, Long> implements IBookCategoryDao {

	private static final Logger logger = Logger.getLogger(BookCategoryDaoImpl.class.getName());
	
	public BookCategoryDaoImpl (Class<BookCategory> clazz) {
		super(clazz);
	}
	
	public BookCategoryDaoImpl() {
		setClazz(BookCategory.class);
	}
	
	@Override
	@Transactional
	public void insertBookCategory(BookCategory bookCategory) {
		logger.info("[insertBookCategory] - Start");
		insert(bookCategory);
		logger.info("[insertBookCategory] - End");
	}
	
	@Override
	@Transactional
	public void updateBookCategory(BookCategory bookCategory) {
		logger.info("[updateBookCategory] - Start");
		update(bookCategory);
		logger.info("[updateBookCategory] - End");
	}
	
	@Override
	@Transactional
	public BookCategory getCategoryById(long id) {
		logger.info("[getCategoryById] - Start: id =" + id);
		BookCategory category = (BookCategory)getById(id);
		logger.info("[getCategoryById] - Start: id =" + id);
		return category;
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
