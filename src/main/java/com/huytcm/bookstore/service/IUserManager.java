package com.huytcm.bookstore.service;

import com.huytcm.bookstore.model.User;

public interface IUserManager {
	
	User getUserbyId(long id);
	User getUserByUsername(String username);
}
