package com.truongjae;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/chuyenhuongtrang")
public class ServletRedirect extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		resp.sendRedirect("https://fb.com");
		resp.setStatus(resp.SC_MOVED_PERMANENTLY);
		resp.setHeader("Location", "https://fb.com");
	}
}
