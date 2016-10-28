package com.huytcm.bookstore.dao;

import com.huytcm.bookstore.model.User;

public interface IUserDao {
	
	User getUserbyId(long id);
	User getByUsername(String username);
}
