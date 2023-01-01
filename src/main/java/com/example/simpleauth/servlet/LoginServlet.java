package com.example.simpleauth.servlet;

import com.example.simpleauth.dto.UserDto;
import com.example.simpleauth.service.UserService;
import com.example.simpleauth.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private final UserService userService = UserService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(JspHelper.getPath("/"))
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userService.login(req.getParameter("login"), req.getParameter("password"))
				.ifPresentOrElse(user -> onLoginSuccess(user, req, resp),
						() -> onLoginFail(req, resp));
	}

	@SneakyThrows
	private void onLoginSuccess(UserDto user, HttpServletRequest req, HttpServletResponse resp) {
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("name", user.getName());
		resp.sendRedirect(JspHelper.getPath("hello"));
	}

	@SneakyThrows
	private void onLoginFail(HttpServletRequest req, HttpServletResponse resp) {
		resp.sendRedirect("/?error");
	}
}
