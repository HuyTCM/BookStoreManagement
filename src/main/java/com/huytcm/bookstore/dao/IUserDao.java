package com.huytcm.bookstore.dao;

import com.huytcm.bookstore.model.User;

public interface IUserDao {
	
	User getByUsername(String username);
}
