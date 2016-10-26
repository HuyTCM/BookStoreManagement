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
	
	public BookDaoImpl (Class<Book> clazz) {
		super(clazz);
	}
	
	public BookDaoImpl() {
		setClazz(Book.class);
	}

	@Override
	@Transactional
	public void insertBook(Book book) {
		logger.info("[insertBook] - Start" + book.getName());
		insert(book);
		logger.info("[insertBook] - End");
	}
	
	@Override
	@Transactional
	public void updateBook(Book book) {
		logger.info("[updateBook] - Start: bookId = " + book.getId());
		update(book);
		logger.info("[updateBook] - End");
	}
	
	@Override
	@Transactional
	public void deleteBook(Book book) {
		logger.info("[deleteBook] - Start: bookId = " + book.getId());
		delete(book);
		logger.info("[deleteBook] - End");
	}
	
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