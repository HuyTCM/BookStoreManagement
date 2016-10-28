package com.huytcm.bookstore.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.service.IBookManager;
import com.huytcm.bookstore.service.IBorrowBookManager;
import com.huytcm.bookstore.service.IUserManager;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	IBookManager bookManager;
	@Autowired
	IUserManager userManager;
	@Autowired
	IBorrowBookManager borrowBookManager;

	@RequestMapping(value = "/book-detail", method = RequestMethod.GET)
	public String getBookDetail() {

		return "book-detail";
	}

	@RequestMapping(value = "/list-book", method = RequestMethod.GET)
	public String getListBook() {
		logger.info("[getListBook] - Start");
		return "list-book";
	}

	@RequestMapping(value = "/grid-book")
	public String getGridListBook(Model model) {
		List<Book> listBook = bookManager.getAllBook();
		model.addAttribute("BOOKS", listBook);
		return "grid-book";
	}

	@RequestMapping(value = "/addBook")
	public void addBook(@RequestParam(name = "txtTitle") String txtTitle,
			@RequestParam(name = "txtPublishedDate") String publishDate,
			@RequestParam(name = "txtDescription") String txtDescription,
			@RequestParam(name = "slAuthor") List<String> authors,
			@RequestParam(name = "slGenre") List<String> category, HttpServletResponse response) {
		logger.info("[addBook] - Start");

		try {
			bookManager.addNewBook(txtTitle, txtDescription, authors, category, publishDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("[addBook] - End");
		try {
			response.sendRedirect("grid-book");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// return "grid-book";
	}

	@RequestMapping(value = "/book-name")
	public @ResponseBody String getBookName(@RequestParam(name = "bookId") String bookId) {
		long id = Long.parseLong(bookId);
		Book book = bookManager.getBookById(id);
		return book.getName();
	}
	
	@RequestMapping(value = "/user-name")
	public @ResponseBody String getUsername(@RequestParam(name = "userId") String userId) {
		long id = Long.parseLong(userId);
		logger.info("[getUsername] - Start: id =" + id);
		User user = userManager.getUserbyId(id);
		return user.getUsername();
	}

	@RequestMapping(value = "/borrow-book")
	public void borrowBook(@RequestParam(name = "txtBookId") String bookId,
			@RequestParam(name = "txtFromDate") String fromDateStr, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		User user = userManager.getUserByUsername(username);
		logger.info("username = " + user.getUsername());
		long id = Long.parseLong(bookId);
		Book book = bookManager.getBookById(id);
		logger.info("bookId = " + book.getId());
		Calendar fromDate = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			fromDate.setTime(sdf.parse(fromDateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		borrowBookManager.userBorrowBook(user, book, fromDate);
		try {
			response.sendRedirect("grid-book");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/return-book")
	public void returnBook(@RequestParam(name = "txtBookId") String bookId,@RequestParam(name = "txtUserId", required = false) String userId,
			@RequestParam(name = "txtFromDate") String fromDateStr, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		User user;
		if (userId != null) {
			long id = Long.parseLong(userId);
			user = userManager.getUserbyId(id);
		} else {
			user = userManager.getUserByUsername(username);
		}
		logger.info("username = " + user.getUsername());
		long id = Long.parseLong(bookId);
		Book book = bookManager.getBookById(id);
		logger.info("bookId = " + book.getId());
		Calendar fromDate = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		try {
			fromDate.setTime(sdf.parse(fromDateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		borrowBookManager.userReturnBook(user, book, fromDate);
		try {
			response.sendRedirect("grid-book");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
