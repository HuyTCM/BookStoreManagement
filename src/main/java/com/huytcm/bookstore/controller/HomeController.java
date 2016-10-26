package com.huytcm.bookstore.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.huytcm.bookstore.model.Author;
import com.huytcm.bookstore.model.BookCategory;
import com.huytcm.bookstore.service.IAuthorManager;
import com.huytcm.bookstore.service.IBookCategoryManager;
import com.huytcm.bookstore.service.IBookManager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	IBookManager bookManager;
	@Autowired
	IAuthorManager authorManager;
	@Autowired
	IBookCategoryManager categoryManager;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {

		return "login";
	}
	@RequestMapping(value = "/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}
	
	@RequestMapping(value = "/add-new-book")
	public String addNewBook(Model model) {
		logger.info("[addNewBook] - Start");
		
		List<Author> authors = authorManager.getAllAuthor();
		List<BookCategory> categories = categoryManager.getAllBookCategory();
		
		model.addAttribute("AUTHORS", authors);
		model.addAttribute("CATEGORIES", categories);
		
		logger.info("[addNewBook] - End");
		return "add-book";
	}
 	
}
