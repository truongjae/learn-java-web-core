package com.truongjae.cookie.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<form action='login' method='post'>");
		printWriter.println("Username: <input type='text' name='username'>");
		printWriter.println("Password: <input type='password' name='password'>");
		printWriter.println("<input type='submit' value='login'>");
		printWriter.println("</form>");
		printWriter.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username.equals("truong") && password.equals("123")) {
			Cookie cookie1 = new Cookie("username","truong");
			cookie1.setMaxAge(5);
			Cookie cookie2 = new Cookie("password","123");
			cookie2.setMaxAge(5);
			resp.addCookie(cookie1);
			resp.addCookie(cookie2);
			resp.sendRedirect("welcome");	
		}
		else {
			resp.sendRedirect("login");	
		}
	}
}
