package com.huytcm.bookstore.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huytcm.bookstore.model.Book;
import com.huytcm.bookstore.service.IBookManager;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	IBookManager bookManager;
	
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
	
	@RequestMapping(value="/addBook")
	public String addBook(@RequestParam(name = "txtTitle") String txtTitle, @RequestParam(name="txtPublishedDate") String publishDate,
			@RequestParam(name="txtDescription") String txtDescription, @RequestParam(name = "slAuthor") List<String> authors,
			@RequestParam(name = "slGenre") List<String> category) {
		logger.info("[addBook] - Start");
		
		System.out.println(publishDate);
		try {
			bookManager.addNewBook(txtTitle, txtDescription, authors, category, publishDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("[addBook] - End");
		return "grid-book";
	}
}
