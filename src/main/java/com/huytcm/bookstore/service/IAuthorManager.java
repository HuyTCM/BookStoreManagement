package com.huytcm.bookstore.service;

import java.util.List;

import com.huytcm.bookstore.model.Author;

public interface IAuthorManager {
	
	Author getAuthorById(String id);
	List<Author> getAllAuthor();
}
