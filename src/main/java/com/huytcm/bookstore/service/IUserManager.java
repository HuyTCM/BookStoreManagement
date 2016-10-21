package com.huytcm.bookstore.service;

import com.huytcm.bookstore.model.User;

public interface IUserManager {
	User getUserByUsername(String username);
}
