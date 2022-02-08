package com.truongjae.demorequestdispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String username = req.getParameter("username");
		if (username.equals("truong")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("welcome");
			dispatcher.forward(req, resp);
		}
		else {
			printWriter.print("user khong chinh xac");
			RequestDispatcher dispatcher = req.getRequestDispatcher("form-login");
			dispatcher.include(req, resp);
		}
	}
}
