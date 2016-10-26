package com.huytcm.bookstore.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.huytcm.bookstore.dao.IAuthorDao;
import com.huytcm.bookstore.model.Author;

@Repository
public class AuthorDaoImpl extends BaseDaoImpl<Author, Long> implements IAuthorDao {

	private static final Logger logger = Logger.getLogger(AuthorDaoImpl.class.getName());
	
	public AuthorDaoImpl (Class<Author> clazz) {
		super(clazz);
	}
	
	public AuthorDaoImpl() {
		setClazz(Author.class);
	}
	
	@Override
	@Transactional
	public void insertAuthor(Author author) {
		logger.info("[insertAuthor] - Start");
		insert(author);
		logger.info("[insertAuthor] - End");
	}
	
	@Override
	@Transactional
	public void updateAuthor(Author author) {
		logger.info("[updateAuthor] - Start");
		update(author);
		logger.info("[updateAuthor] - End");
	}
	
	@Override
	@Transactional
	public List<Author> getAllAuthor() {
		logger.info("[getAllAuthor] - Start");
		List<Author> listAuthor = getAll();
		logger.info("[getAllAuthor] - End");
		return listAuthor;
	}

	@Override
	@Transactional
	public Author getAuthorById(long id) {
		logger.info("[getAuthorById] - Start: id = " + id);
		Author author = getById(id);
		logger.info("[getAuthorById] - End");
		return author;
	}

}
