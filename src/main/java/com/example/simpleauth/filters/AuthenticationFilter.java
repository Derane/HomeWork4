package com.example.simpleauth.filters;

import com.example.simpleauth.dto.UserDto;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;


@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	private static final Set<String> PUBLIC_PATH = Set.of("/", "/login");

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
		String uri = ((HttpServletRequest) servletRequest).getRequestURI();
		if (isPublicPath(uri) || isUserLoggedIn(servletRequest) || "/".equals(uri)) {
			filterChain.doFilter(servletRequest, servletResponse);
		} else {
			((HttpServletResponse) servletResponse).sendRedirect("/");
		}
	}

	private boolean isUserLoggedIn(ServletRequest servletRequest) {
		UserDto user = (UserDto) ((HttpServletRequest) servletRequest).getSession().getAttribute("user");
		return user != null;
	}

	private boolean isPublicPath(String uri) {
		return PUBLIC_PATH.stream().anyMatch(uri::equalsIgnoreCase);
	}

}