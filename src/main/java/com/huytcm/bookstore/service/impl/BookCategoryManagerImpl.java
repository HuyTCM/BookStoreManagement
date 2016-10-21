package com.huytcm.bookstore.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.huytcm.bookstore.dao.IBookCategoryDao;
import com.huytcm.bookstore.model.BookCategory;
import com.huytcm.bookstore.service.IBookCategoryManager;

public class BookCategoryManagerImpl implements IBookCategoryManager {
	
	private static final Logger logger = Logger.getLogger(BookCategoryManagerImpl.class.getName());

	@Autowired
	private IBookCategoryDao bookCategoryDao;
	
	@Override
	public List<BookCategory> getAllBookCategory() {
		logger.info("[getAllBookCategory] - Start");
		List<BookCategory> categories = bookCategoryDao.getAllBookCategory();
		if (categories.size() == 0) {
			// create dummy data
			logger.info("[getAllBookCategory] - Start: create dummy data");
			BookCategory romanceCategory = new BookCategory();
			romanceCategory.setName("Romance");
			bookCategoryDao.insertBookCategory(romanceCategory);
			
			BookCategory childrenCategory = new BookCategory();
			childrenCategory.setName("Children's");
			bookCategoryDao.insertBookCategory(childrenCategory);
			
			BookCategory biographiesCategory = new BookCategory();
			biographiesCategory.setName("Biographies");
			bookCategoryDao.insertBookCategory(biographiesCategory);
		
			logger.info("[getAllBookCategory] - End: create dummy data");
			return bookCategoryDao.getAllBookCategory();
		}
		logger.info("[getAllBookCategory] - End");
		return categories;
	}

}
