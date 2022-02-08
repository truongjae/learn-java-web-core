package com.truongjae;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/responsedemo")
public class ResponseServletDemo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("hehehe");
		resp.addCookie(new Cookie("username", "truong"));
		resp.addHeader("pass", "ok");
		resp.sendError(200);
		printWriter.close();
	}

}
