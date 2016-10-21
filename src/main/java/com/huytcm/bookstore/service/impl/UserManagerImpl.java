package com.huytcm.bookstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytcm.bookstore.dao.IUserDao;
import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.service.IUserManager;

@Service
public class UserManagerImpl implements IUserManager {

	@Autowired IUserDao userDao;
	
	@Override
	public User getUserByUsername(String username) {
		return userDao.getByUsername(username);
	}

}
