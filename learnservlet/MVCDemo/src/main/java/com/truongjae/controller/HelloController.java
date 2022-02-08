package com.truongjae.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.truongjae.model.User;

@WebServlet(urlPatterns = "/hello")
public class HelloController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		ArrayList<User> listUser = user.getListUser();
		req.setAttribute("listuser", listUser);
		RequestDispatcher dispatcher = req.getRequestDispatcher("hello.jsp");
		dispatcher.forward(req, resp);
	}
}
