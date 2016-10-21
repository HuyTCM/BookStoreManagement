package com.huytcm.bookstore.dao.impl;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.huytcm.bookstore.dao.IUserDao;
import com.huytcm.bookstore.model.User;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Id> implements IUserDao {
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	@Override
	@Transactional
	public User getByUsername(String username) {
		logger.info("[getByUsername] - Start: username = " + username);
		String sql = "FROM " + User.class.getSimpleName() + " WHERE username = :username";
		Query query = getSession().createQuery(sql);
		query.setParameter("username", username);
		logger.info("[getByUsername] - End");
		return (User)query.uniqueResult();
	}
	
}