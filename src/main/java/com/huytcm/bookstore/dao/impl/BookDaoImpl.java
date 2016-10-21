package com.huytcm.bookstore.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.huytcm.bookstore.dao.IBookDao;
import com.huytcm.bookstore.model.Book;

@Repository
public class BookDaoImpl extends BaseDaoImpl<Book, Long> implements IBookDao {

	private static final Logger logger = Logger.getLogger(BookDaoImpl.class.getName());

	@Override
	@Transactional
	public List<Book> getAllBooks() {
		logger.info("[getAllBooks - Start]");
		List<Book> listBook = getAll();
		logger.info("[getAllBooks - End]");
		return listBook;
	}

	@Override
	@Transactional
	public Book getBookById(long id) {
		logger.info("[getBookById - Start]");
		Book book = (Book)getById(id);
		logger.info("[getBookById] - End");
		return book;
	}
	
	

}
