package com.huytcm.bookstore.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huytcm.bookstore.dao.IUserDao;
import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.service.IUserManager;

@Service
public class UserManagerImpl implements IUserManager {

	private static final Logger logger = Logger.getLogger(UserManagerImpl.class.getName());
	
	@Autowired 
	IUserDao userDao;
	
	
	@Override
	public User getUserbyId(long id) {
		return userDao.getUserbyId(id);
	}
	
	@Override
	public User getUserByUsername(String username) {
		logger.info("[getUserByUsername] - Start - End");
		return userDao.getByUsername(username);
	}
	

}
