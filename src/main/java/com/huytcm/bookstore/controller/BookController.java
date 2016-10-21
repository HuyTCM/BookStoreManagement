package com.huytcm.bookstore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
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
	public String getGridListBook() {
		return "grid-book";
	}
}
