package com.huytcm.bookstore.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.huytcm.bookstore.model.User;
import com.huytcm.bookstore.service.IUserManager;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = Logger.getLogger(UserDetailsServiceImpl.class);
	@Autowired
	private IUserManager userManager;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("[loadUserByUsername] - Start: username = " + username);
		
		User user = userManager.getUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User " + username + " doesn't exist!");
		}
		List<GrantedAuthority> authorities = buildUserAuthority(user.isAdmin());
		
		org.springframework.security.core.userdetails.User userDetail = 
				new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
		
		logger.info("[loadUserByUsername] - End");
		return userDetail;
	}
	
	private List<GrantedAuthority> buildUserAuthority(Boolean userRoles) {
        logger.info("[buildUserAuthority] - Start: userRole = " + userRoles);
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        setAuths.add(new SimpleGrantedAuthority(userRoles ? "ADMIN" : "USER"));

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        logger.info("[buildUserAuthority] - End");
        return Result;
    }

}
