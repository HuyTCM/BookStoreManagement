package com.huytcm.bookstore.dao;

import java.util.List;

import com.huytcm.bookstore.model.Author;

public interface IAuthorDao {
	
	void insertAuthor(Author author);
	void updateAuthor(Author author);
	
	List<Author> getAllAuthor();
	Author getAuthorById(long id);
}
