package com.huytcm.bookstore.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytcm.bookstore.constant.BookStatus;
import com.huytcm.bookstore.dao.IBookDao;
import com.huytcm.bookstore.model.Author;
import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.model.BookCategory;
import com.huytcm.bookstore.service.IAuthorManager;
import com.huytcm.bookstore.service.IBookCategoryManager;
import com.huytcm.bookstore.service.IBookManager;

@Service
public class BookManagerImpl implements IBookManager {

	private static final Logger logger = Logger.getLogger(BookManagerImpl.class.getName());

	@Autowired
	private IBookDao bookDao;

	@Autowired
	private IAuthorManager authorManager;
	@Autowired
	private IBookCategoryManager bookCategoryManager;
	
	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}
	
	@Override
	public Book getBookById(long id) {
		logger.info("[getBookById] - Start: id =" + id);
		Book book = bookDao.getBookById(id);
		logger.info("[getBookById] - End");
		return book;
	}

	@Override
	public List<Book> getAllBook() {
		logger.info("[getAllBook] - Start");
		List<Book> books = bookDao.getAllBooks();
//		if (books.size() == 0) {
//			// create dummy data
//			logger.info("[getAllBook] - Start: create dummy data");
//			List<Author> authors = authorManager.getAllAuthor();
//			List<BookCategory> categories = bookCategoryManager.getAllBookCategory();
//
//			for (BookCategory category : categories) {
//				for (Author author : authors) {
//					String bookName = "Book about " + category.getName() + " of " + author.getName();
//					String description = "Book name " + bookName + " with short description about this book.";
//					addBook(bookName, description, authors, categories, Calendar.getInstance());
//				}
//			}
//			logger.info("[getAllBook] - End: create dummy data");
//			return bookDao.getAllBooks();
//		}
		logger.info("[getAllBook] - End");
		return books;
	}

	@Override
	public void addNewBook(String title, String description, List<String> authorsId, List<String> categoriesId,
			String publishedDate) throws ParseException {
		logger.info("[addNewBook] - Start: title = " + title);
		List<Author> authors = new ArrayList<Author>();
		for (String id : authorsId) {
			Author author = authorManager.getAuthorById(id);
			if (author != null) {
				authors.add(author);
			}
		}
		
		List<BookCategory> categories = new ArrayList<BookCategory>();
		for (String id : categoriesId) {
			BookCategory category = bookCategoryManager.bookCategoryById(id);
			if (category != null) {
				categories.add(category);
			}
		}
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		cal.setTime(sdf.parse(publishedDate));
		
		addBook(title, description, authors, categories, cal);
		logger.info("[addNewBook] - End");
	}

	public void addBook(String title, String description, List<Author> authors, List<BookCategory> categories,
			Calendar publishedDate) {
		logger.info("[addBook] - Start: title = " + title);
		Book book = new Book();
		book.setName(title);
		
		bookDao.insertBook(book);
		
		for (Author author : authors) {
			author.getBooks().add(book);
			book.getAuthors().add(author);
			
			authorManager.updateAuthor(author);
		}
		for (BookCategory bookCategory : categories) {
			bookCategory.getListBook().add(book);
			book.getBookCategories().add(bookCategory);
			
			bookCategoryManager.updateCategory(bookCategory);
		}
		book.setDescription(description);
		book.setPublishedDate(publishedDate);
		book.setStatus(BookStatus.AVAILABLE);

		bookDao.updateBook(book);

		logger.info("[addBook] - End");
	}

}
