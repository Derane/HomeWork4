package com.example.simpleauth.servlet;

import com.example.simpleauth.dto.UserDto;
import com.example.simpleauth.service.UserService;
import com.example.simpleauth.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

	private final UserService userService = UserService.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserDto> users = userService.getAll();
		req.getSession().setAttribute("users", users);
		getServletContext().getRequestDispatcher(JspHelper.getPath("usersList")).forward(req, resp);
	}

}
