package com.huytcm.bookstore.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytcm.bookstore.dao.IAuthorDao;
import com.huytcm.bookstore.model.Author;
import com.huytcm.bookstore.service.IAuthorManager;

@Service
public class AuthorManagerImpl implements IAuthorManager {

	private static final Logger logger = Logger.getLogger(AuthorManagerImpl.class.getName());
	
	@Autowired
	private IAuthorDao authorDao;
	
	@Override
	public Author getAuthorById(String id) {
		logger.info("[getAuthorById] - Start: id = " + id);
		
		long idValue = Long.parseLong(id);
		Author author = authorDao.getAuthorById(idValue);
		
		logger.info("[getAuthorById] - End");
		return author;
	}
	
	@Override
	public List<Author> getAllAuthor() {
		logger.info("[getAllAuthor] - Start");
		List<Author> authors = authorDao.getAllAuthor();
		if (authors.size() == 0) {
			// create dummy data
			logger.info("[getAllAuthor] - Start: create dummy data");
			for (int i = 0; i < 3; i++) {
				Author author = new Author();
				author.setName("Author 1");
				authorDao.insertAuthor(author);
			}
			logger.info("[getAllAuthor] - End: create dummy data");
			return authorDao.getAllAuthor();
		}
		logger.info("[getAllAuthor] - End");
		return authors;
	}

}
