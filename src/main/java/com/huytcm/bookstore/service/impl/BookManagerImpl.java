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
	public List<Book> getAllBook() {
		logger.info("[getAllBook] - Start");
		List<Book> books = bookDao.getAllBooks();
		if (books.size() == 0) {
			// create dummy data
			logger.info("[getAllBook] - Start: create dummy data");
			List<Author> authors = authorManager.getAllAuthor();
			List<BookCategory> categories = bookCategoryManager.getAllBookCategory();

			for (BookCategory category : categories) {
				for (Author author : authors) {
					Book book = new Book();
					String bookName = "Book about " + category.getName() + " of " + author.getName();
					book.setName(bookName);
					book.setPublishedDate(Calendar.getInstance());
					book.setDescription("Book name " + bookName + " with short description about this book.");

					List<Author> bookAuthors = new ArrayList<Author>();
					bookAuthors.add(author);
					book.setAuthors(bookAuthors);

					List<BookCategory> bookCategories = new ArrayList<BookCategory>();
					bookCategories.add(category);
					book.setBookCategories(bookCategories);

					bookDao.insertBook(book);
				}
			}
			logger.info("[getAllBook] - End: create dummy data");
			return bookDao.getAllBooks();
		}
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
		book.setAuthors(authors);
		book.setBookCategories(categories);
		book.setDescription(description);
		book.setPublishedDate(publishedDate);
		book.setStatus(BookStatus.AVAILABLE);

		bookDao.insertBook(book);

		logger.info("[addBook] - End");
	}

}
