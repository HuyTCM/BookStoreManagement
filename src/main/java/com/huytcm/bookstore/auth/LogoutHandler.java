package com.huytcm.bookstore.auth;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutHandler implements LogoutSuccessHandler {

	private static final Logger logger = Logger.getLogger(LogoutHandler.class);

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String username = authentication.getName();
		logger.info(new StringBuilder("[onLogoutSuccess] - Start: username = ").append(username));
		logger.info("[onLogoutSuccess] - End");
		response.sendRedirect("login?loggedUsername=" + username);
	}
}
